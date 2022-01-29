//package kz.attractorschool.forum;
//
//import com.github.javafaker.Faker;
//import kz.attractorschool.forum.domain.item.Item;
//import kz.attractorschool.forum.domain.item.ItemCategory;
//import kz.attractorschool.forum.domain.item.ItemRepository;
//import kz.attractorschool.forum.domain.topic.TopicRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.Random;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//@Configuration
//@RequiredArgsConstructor
//public class DatabaseInitilizer {
//  private final TopicRepository topicRepository;
//
//  private static final List<ItemCategory> CATEGORIES =
//      Collections.unmodifiableList(Arrays.asList(ItemCategory.values()));
//  private static final int SIZE = CATEGORIES.size();
//  private static final Random RANDOM = new Random();
//
//  @Bean
//  public CommandLineRunner init() {
//    return (args -> {
//      if (itemRepository.count() == 0) {
//        itemRepository.deleteAll();
//        var faker = new Faker();
//        var items = Stream.generate(() -> new Item()
//            .setName(faker.commerce().productName())
//            .setCategory(CATEGORIES.get(RANDOM.nextInt(SIZE)))
//            .setDescription(faker.internet().userAgentAny())
//            .setCount(RANDOM.nextInt(100))
//            .setImagePath("/img/" + (RANDOM.nextInt(5) + 1) + ".jpg")
//            .setPrice(RANDOM.nextInt(10000000)))
//            .limit(149)
//            .collect(Collectors.toList());
//        itemRepository.saveAll(items);
//      }
//    });
//  }
//}
