package by.tms.eshop.services;

import by.tms.eshop.dto.CategoryDto;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public interface CategoryService {

  Set<CategoryDto> getAllCategoriesDto();

  ModelAndView openCategoryPage(HttpSession httpSession);

  ResponseEntity<Set<CategoryDto>> saveCategoriesFromFile(MultipartFile file) throws Exception;

  ResponseEntity<Set<CategoryDto>> downloadCategoriesCSV(PrintWriter printWriter) throws Exception;
}
