package com.tweteroo.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tweteroo.api.models.TweetModel;

@Repository
public interface TweetRepository extends JpaRepository<TweetModel, Long> {
  @Query("SELECT t FROM TweetModel t WHERE t.user.id = :userId")
  List<TweetModel> findAllByUserId(@Param("userId") Long userId);
}
