package daggerok.test;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TestRestController {

  final TestRepository testRepository;

  @GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
  public List<TestEntity> get() {
    return testRepository.findAll();
  }

  @PostMapping
  @Transactional
  public TestEntity post(@RequestBody String value) {
    return testRepository.save(TestEntity.of(value));
  }
}
