package com.example.SpringBootPractice.service.posts;

import com.example.SpringBootPractice.domain.posts.Posts;
import com.example.SpringBootPractice.domain.posts.PostsRepository;
import com.example.SpringBootPractice.web.dto.PostsResponseDto;
import com.example.SpringBootPractice.web.dto.PostsSaveRequestDto;
import com.example.SpringBootPractice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto)
    {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public PostsResponseDto findById(Long id)
    {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 사용자가 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto)
    {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id ="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
}
