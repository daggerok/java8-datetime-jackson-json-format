package daggerok.test;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TestRestController {

  final TestRepository testRepository;

  @PostMapping
  @Transactional
  public TestEntity post(@RequestBody TestEntity testEntity) {
    return testRepository.save(testEntity);
  }
}
