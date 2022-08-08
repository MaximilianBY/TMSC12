package by.tms.soap;

import by.tms.soap.model.GetStudentRequest;
import by.tms.soap.model.GetStudentResponse;
import by.tms.soap.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class StudentEndpoint {

  private static final String NAMESPACE_URI = "http://www.baeldung.com/springsoap/gen";

  private StudentRepository studentRepository;

  @Autowired
  public StudentEndpoint(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStudentRequest")
  @ResponsePayload
  public GetStudentResponse getStudent(@RequestPayload GetStudentRequest request) {
    GetStudentResponse response = new GetStudentResponse();
    response.setStudent(studentRepository.findStudent(request.getName(), request.getSurname()));

    return response;
  }
}
