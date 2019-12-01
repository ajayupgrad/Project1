package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentRepository;
import ImageHoster.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {


        @Autowired
        private CommentRepository commentRepository;

        //Call the getAllImages() method in the Repository and obtain a List of all the images in the database
        public List<Comment> getAllComments() {
        return commentRepository.findAllComments();
    }

        //The method calls the updateImage() method in the Repository and passes the Image to be updated in the database
        public void createComment(Comment comment) {
        commentRepository.createComment(comment);
    }

    }



