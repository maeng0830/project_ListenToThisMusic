package com.maeng0830.listentothismusic.repository;

import com.maeng0830.listentothismusic.code.postCode.PostStatusCode;
import com.maeng0830.listentothismusic.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByPostStatusNot(PostStatusCode postStatusCode, Pageable pageable);

    Page<Post> findByPostStatus(PostStatusCode report, Pageable pageable);

    Page<Post> findByTitleContainingOrMusicTitleContainingAndPostStatusNot(String musicTitle,
        String artist, PostStatusCode postStatusCode, Pageable pageable);
}
