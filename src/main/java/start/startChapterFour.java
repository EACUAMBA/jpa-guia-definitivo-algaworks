package start;

import util.JpaUtil;

import javax.persistence.EntityManager;

public class startChapterFour {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
    }
}
