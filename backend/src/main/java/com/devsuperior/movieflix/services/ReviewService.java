package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.repositories.UserRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public ReviewDTO insert(ReviewDTO dto) {
		Review review = new Review();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User userAuthenticated = userRepository.findByEmail(authentication.getName());
		review.setUser(userAuthenticated);
		
		review.setText(dto.getText());
		
		Movie movie = movieRepository.getOne(dto.getMovieId());
		review.setMovie(movie);		
		
		review = repository.save(review);		
		return new ReviewDTO(review);
	}
	
	@Transactional(readOnly = true)
	public List<ReviewDTO> reviewByMovie(Long movieId) {
		List<Review> list = repository.findByMovie(movieId);
		return list.stream().map(x -> new ReviewDTO(x)).collect(Collectors.toList());
	}
}
