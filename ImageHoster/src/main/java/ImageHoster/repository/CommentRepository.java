package ImageHoster.repository;

import ImageHoster.model.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CommentRepository {
    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    public Comment createComment(Comment comment) {
        EntityManager emc = emf.createEntityManager();
        EntityTransaction transactions = emc.getTransaction();

        try {
            transactions.begin();
            emc.persist(comment);
            transactions.commit();
        } catch (Exception e) {
            transactions.rollback();
        }
        return comment;
    }

    public List<Comment> findAllComments() {EntityManager em = emf.createEntityManager();
        TypedQuery<Comment> query = em.createQuery("SELECT c from Comment c", Comment.class);
        List<Comment> resultList = query.getResultList();

        return resultList;
    }
}
