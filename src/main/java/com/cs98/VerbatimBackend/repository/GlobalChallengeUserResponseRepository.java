package com.cs98.VerbatimBackend.repository;

import com.cs98.VerbatimBackend.model.GlobalChallengeUserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalChallengeUserResponseRepository extends JpaRepository<GlobalChallengeUserResponse, Integer> {

    Integer countByGlobalChallengeId(int id);

    Integer countByResponseQ1AndGlobalChallengeIdAndUserIdNot(String responseQ1, int challengeId, int userId);

    Integer countByResponseQ2AndGlobalChallengeIdAndUserIdNot(String responseQ2, int challengeId, int userId);

    Integer countByResponseQ3AndGlobalChallengeIdAndUserIdNot(String responseQ3, int challengeId, int userId);

    Integer countByResponseQ1AndGlobalChallengeId(String responseQ1, int challengeId);

    Integer countByResponseQ2AndGlobalChallengeId(String responseQ1, int challengeId);

    Integer countByResponseQ3AndGlobalChallengeId(String responseQ1, int challengeId);

    Integer countByResponseQ1AndResponseQ2AndResponseQ3AndGlobalChallengeIdAndUserIdNot(
            String responseQ1,
            String responseQ2,
            String responseQ3,
            int challengeId,
            int userId);

    Boolean existsByUserIdAndGlobalChallengeId(int userId, int challengeId);

    // select mode() within group (order by responseq1) from global_challenge_response where global_challenge_id = 1;
    @Query(value = "SELECT MODE() WITHIN GROUP (ORDER BY responseq1) " +
            "FROM global_challenge_response WHERE global_challenge_id = ?1",
            nativeQuery = true)
    String findMostPopularQ1ResponseByChallengeId(Integer id);

    @Query(value = "SELECT MODE() WITHIN GROUP (ORDER BY responseq1) " +
            "FROM global_challenge_response WHERE global_challenge_id = ?1 " +
            "AND responseq1 != ?2",
            nativeQuery = true)
    String findSecondMostPopularQ1ResponseByChallengeId(Integer id, String mostPopularQ1);

    @Query(value = "SELECT MODE() WITHIN GROUP (ORDER BY responseq1) " +
            "FROM global_challenge_response WHERE global_challenge_id = ?1 " +
            "AND responseq1 != ?2 AND responseq1 != ?3",
            nativeQuery = true)
    String findThirdMostPopularQ1ResponseByChallengeId(
            Integer id,
            String mostPopularQ1,
            String secondMostPopularQ1);

    @Query(value = "SELECT MODE() WITHIN GROUP (ORDER BY responseq2) " +
            "FROM global_challenge_response WHERE global_challenge_id = ?1 ",
            nativeQuery = true)
    String findMostPopularQ2ResponseByChallengeId(Integer id);

    @Query(value = "SELECT MODE() WITHIN GROUP (ORDER BY responseq2) " +
            "FROM global_challenge_response WHERE global_challenge_id = ?1 " +
            "AND responseq2 != ?2",
            nativeQuery = true)
    String findSecondMostPopularQ2ResponseByChallengeId(Integer id, String mostPopularQ2);

    @Query(value = "SELECT MODE() WITHIN GROUP (ORDER BY responseq2) " +
            "FROM global_challenge_response WHERE global_challenge_id = ?1 " +
            "AND responseq2 != ?2 AND responseq2 != ?3",
            nativeQuery = true)
    String findThirdMostPopularQ2ResponseByChallengeId(
            Integer id,
            String mostPopularQ2,
            String secondMostPopularQ2);

    @Query(value = "SELECT MODE() WITHIN GROUP (ORDER BY responseq3) " +
            "FROM global_challenge_response WHERE global_challenge_id = ?1",
            nativeQuery = true)
    String findMostPopularQ3ResponseByChallengeId(Integer id);

    @Query(value = "SELECT MODE() WITHIN GROUP (ORDER BY responseq3) " +
            "FROM global_challenge_response WHERE global_challenge_id = ?1 " +
            "AND responseq3 != ?2",
            nativeQuery = true)
    String findSecondMostPopularQ3ResponseByChallengeId(Integer id, String mostPopularQ3);

    @Query(value = "SELECT MODE() WITHIN GROUP (ORDER BY responseq3) " +
            "FROM global_challenge_response WHERE global_challenge_id = ?1 " +
            "AND responseq3 != ?2 AND responseq3 != ?3",
            nativeQuery = true)
    String findThirdMostPopularQ3ResponseByChallengeId(
            Integer id,
            String mostPopularQ3,
            String secondMostPopularQ3);
}