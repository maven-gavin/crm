package com.yuanbao.crm.common.repository;

import com.yuanbao.crm.common.entity.SchoolType;
import com.yuanbao.crm.common.entity.Sex;
import com.yuanbao.crm.common.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by gewen on 2017/1/20.
 */
public interface UserRepository extends BaseRepository<User,Long>, JpaSpecificationExecutor<User> {

    @Modifying
    @Query("update BaseInfo bi set bi.realname = ?1 where bi.user.id = ?2")
    public void updateRealname(String realname, Long userId);

    @Modifying
    @Query("update BaseInfo bi set bi.realname = :realname where bi.user.id = :userId")
    public void updateRealnameWithNamedParam(@Param("realname") String realname, @Param("userId") Long userId);

    @Modifying
    @Query("delete from BaseInfo bi where bi.user.id = ?1")
    public void deleteBaseInfoByUser(Long userId);

    /**
     * 条件查询 自动生成
     *
     * @param username
     * @return
     */
    public User findByUsername(String username);


    /**
     * 关联查询 自动生成
     *
     * @param sex
     * @return
     */
    public User findByBaseInfoSex(Sex sex);

    public Page<User> findByBaseInfoSex(Sex sex, Pageable pageable);

    public List<User> findByBaseInfoSex(Sex sex, Sort sort);

    /**
     * 关联查询 和 and逻辑查询
     *
     * @param sex
     * @param type
     * @return
     */
    @Query("select u from User u, BaseInfo bi, SchoolInfo si where bi.user = u and si.user = u and bi.sex = ?1 and si.type = ?2")
    public User findByBaseInfoSexAndShcoolInfoSetType(Sex sex, SchoolType type);
}
