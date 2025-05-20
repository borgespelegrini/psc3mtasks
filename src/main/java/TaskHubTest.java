import Moldes.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TaskHubTest {

    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();

        try {
            // Criar Usuario
            Usuario usuario1 = new Usuario(
                    1,
                    "Dick",
                    "dick@gmail.com",
                    "12345678");
            Usuario usuario2 = new Usuario(
                    1,
                    "marcelo",
                    "marcelo@gmail.com",
                    "12345679");

            em.getTransaction().begin();
            em.persist(usuario1);
            em.persist(usuario2);
            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }
}
