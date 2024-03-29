package com.tweteroo.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.services.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetController {
  
  final TweetService tweetService;

  TweetController(TweetService tweetService){
    this.tweetService = tweetService;
  }

  @PostMapping
  public ResponseEntity<Object> createTweet(@RequestBody @Valid TweetDTO body){
    Optional<TweetModel> tweet = tweetService.save(body);

    return ResponseEntity.status(HttpStatus.CREATED).body(tweet);
  }

  @GetMapping
  public ResponseEntity<List<TweetModel>> getTweets() {
    List<TweetModel> tweet = tweetService.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(tweet);
  }

  @GetMapping("/users/{userId}")
  public ResponseEntity<List<TweetModel>> getTweetsByUserId(@PathVariable Long userId) {
    List<TweetModel> tweets = tweetService.findByUserId(userId);
    return ResponseEntity.status(HttpStatus.OK).body(tweets);
  }
}
