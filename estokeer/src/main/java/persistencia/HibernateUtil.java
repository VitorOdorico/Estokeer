package persistencia;


import Entities.ItensArmazenados;
import Entities.LocalArmazenado;
import Entities.Lote;
import Entities.MovimentacaoDeArmazem;
import Entities.Product;
import Entities.User;
import Entities.Venda;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

    private static final SessionFactory factory;
    private static final ThreadLocal sessionThread = new ThreadLocal();
    private static final ThreadLocal transactionThread = new ThreadLocal();

    public static Session getSession() {
        Session session = (Session) sessionThread.get();
        if ((session == null) || (!(session.isOpen()))) {
            session = factory.openSession();
            sessionThread.set(session);
        }
        return ((Session) sessionThread.get());
    }

    public static void closeSession() {
        Session session = (Session) sessionThread.get();
        if ((session != null) && (session.isOpen())) {
            sessionThread.set(null);
            session.close();
        }
    }

    public static void beginTransaction() {
        Transaction transaction = getSession().beginTransaction();
        transactionThread.set(transaction);
    }

    public static void commitTransaction() {
        Transaction transaction = (Transaction) transactionThread.get();
        if ((transaction != null) && (!(transaction.wasCommitted())) && (!(transaction.wasRolledBack()))) {
            transaction.commit();
            transactionThread.set(null);
        }
    }

    public static void rollbackTransaction() {
        Transaction transaction = (Transaction) transactionThread.get();
        if ((transaction != null) && (!(transaction.wasCommitted())) && (!(transaction.wasRolledBack()))) {
            transaction.rollback();
            transactionThread.set(null);
        }
    }
//configuração do hibernate para conexão com banco de dados

    static {
        try {
            factory = new AnnotationConfiguration()
                    //                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                    //                    .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
                    //                    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3307/sistemapoo")
                    
                    //The artifact mysql:mysql-connector-java:jar:8.0.33 has been relocated to com.mysql:mysql-connector-j:jar:8.0.33: MySQL Connector/J artifacts moved to reverse-DNS compliant Maven 2+ coordinates.

                    //Dialeto do banco de dados.
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                    //Drive JDBC do banco de dados.
                    .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                    //url do banco, indica o caminho onde se encontra o banco de dados. Local, porta e nome do banco.
                    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/estokeer")
                    //usuário do banco de dados
                    .setProperty("hibernate.connection.username", "root")
                    //senha do banco de dados
                    .setProperty("hibernate.connection.password", "Ve26022003+")
                    .setProperty("hibernate.hbm2ddl.auto", "update")
                    .setProperty("hibernate.c3p0.max_size", "10")
                    .setProperty("hibernate.c3p0.min_size", "2")
                    .setProperty("hibernate.c3p0.timeout", "5000")
                    .setProperty("hibernate.c3p0.max_statements", "10")
                    .setProperty("hibernate.c3p0.idle_test_period", "3000")
                    .setProperty("hibernate.c3p0.acquire_increment", "2")
                    .setProperty("use_outer_join", "true")
                    .setProperty("hibernate.generate_statistics", "true")
                    .setProperty("hibernate.use_sql_comments", "true")
                    .setProperty("show_sql", "true")
                    .setProperty("hibernate.format_sql", "true")
                    //.addAnnotatedClass(Estado.class)
                    .addAnnotatedClass(Product.class)
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(ItensArmazenados.class)
                    .addAnnotatedClass(LocalArmazenado.class)
                    .addAnnotatedClass(Lote.class)
                    .addAnnotatedClass(MovimentacaoDeArmazem.class)
                    .addAnnotatedClass(Venda.class)
                    .buildSessionFactory();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
