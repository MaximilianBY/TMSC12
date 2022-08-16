package by.tms.eshop.services.impl;

import static by.tms.eshop.PagesPathConstants.HOME_PAGE;
import static by.tms.eshop.RequestParamsEnum.CATEGORY;

import by.tms.eshop.dto.CategoryDto;
import by.tms.eshop.dto.converters.CategoryConverter;
import by.tms.eshop.repositories.CategoryDao;
import by.tms.eshop.services.CategoryService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

  private final CategoryDao categoryDao;
  private final CategoryConverter categoryConverter;

  public CategoryServiceImpl(CategoryDao categoryDao, CategoryConverter categoryConverter) {
    this.categoryDao = categoryDao;
    this.categoryConverter = categoryConverter;
  }

  @Override
  public Set<CategoryDto> getAllCategoriesDto() {
    return categoryDao.getAllCategories();
  }

  @Override
  public ModelAndView openCategoryPage(HttpSession httpSession) {
    ModelMap modelMap = new ModelMap();
    Set<CategoryDto> categorySet = categoryDao.getAllCategories();
    httpSession.setAttribute(CATEGORY.getValue(), categorySet);
    return new ModelAndView(HOME_PAGE);
  }

  @Override
  public ResponseEntity<Set<CategoryDto>> saveCategoriesFromFile(MultipartFile file)
      throws Exception {
    List<CategoryDto> csvCategories = parseCsv(file);
    if (Optional.ofNullable(csvCategories).isPresent()) {
      return new ResponseEntity<>(new HashSet<>(csvCategories), HttpStatus.CREATED);
    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  private List<CategoryDto> parseCsv(MultipartFile file) {
    if (Optional.ofNullable(file).isPresent()) {
      try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
        CsvToBean<CategoryDto> csvToBean = new CsvToBeanBuilder(reader)
            .withType(CategoryDto.class)
            .withIgnoreLeadingWhiteSpace(true)
            .withSeparator(',')
            .build();

        return csvToBean.parse();
      } catch (Exception ex) {
        log.error("Exception occurred during CSV parsing: {}", ex.getMessage());
      }
    } else {
      log.error("Empty CSV file is uploaded.");
    }
    return Collections.emptyList();
  }

  @Override
  public ResponseEntity<Set<CategoryDto>> downloadCategoriesCSV(PrintWriter printWriter)
      throws Exception {
    Set<CategoryDto> allCategories = categoryDao.getAllCategories();
    String[] CSV_HEADER = {"name", "imagePath"};
    StatefulBeanToCsv<CategoryDto> beanToCsv = null;

    try (CSVWriter writer = new CSVWriter(printWriter,
        CSVWriter.DEFAULT_SEPARATOR,
        CSVWriter.NO_QUOTE_CHARACTER,
        CSVWriter.NO_ESCAPE_CHARACTER,
        CSVWriter.DEFAULT_LINE_END)) {

      writer.writeNext(CSV_HEADER);

      ColumnPositionMappingStrategy<CategoryDto> mappingStrategy =
          new ColumnPositionMappingStrategy<CategoryDto>();

      mappingStrategy.setType(CategoryDto.class);
      mappingStrategy.setColumnMapping(CSV_HEADER);

      beanToCsv = new StatefulBeanToCsvBuilder<CategoryDto>(writer)
          .withMappingStrategy(mappingStrategy)
          .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
          .build();

      beanToCsv.write(allCategories.stream().toList());
      return ResponseEntity.ok()
          .body(allCategories);
    } catch (Exception e) {
      log.info("Error writing category CSV");
    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
