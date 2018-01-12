package top.chuqin.repository;

import top.chuqin.domian.Spitter;

import java.util.List;

/**
 * Created by wengchuqin on 2018/1/12.
 */
public interface SpitterRepository {
    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();
}
