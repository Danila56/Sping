package ua.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.DAO.DAO;
import ua.model.CatEntity;

import java.util.List;

/**
 * Created by User on 07.06.2017.
 */
@Service
public class CatSevice {
    DAO dao;
    public void setDao(DAO dao) {
        this.dao = dao;
    }
    @Transactional
    public void addCat(CatEntity cat){
        dao.addCat(cat);
    }
    @Transactional
    public List<CatEntity> showCat(){
        return dao.showCat();
    }
    @Transactional
    public void deleteCat(int id){
        dao.deleteCat(id);
    }
    @Transactional
    public void editCat(CatEntity cat){
        dao.editCat(cat);
    }
    @Transactional
    public CatEntity searchCat(int id){
        return dao.searchCat(id);
    }
}
