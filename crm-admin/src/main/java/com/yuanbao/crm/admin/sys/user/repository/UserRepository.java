package com.yuanbao.crm.admin.sys.user.repository;

import com.yuanbao.crm.admin.sys.user.entity.User;
import com.yuanbao.crm.admin.sys.user.entity.UserOrganizationJob;
import com.yuanbao.crm.common.repository.BaseRepository;
import com.yuanbao.crm.common.repository.support.annotation.SearchableQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by gewen on 2017/1/21.
 */
@SearchableQuery(callbackClass = UserSearchCallback.class)
public interface UserRepository extends BaseRepository<User,Long> {
    User findByUsername(String username);

    User findByMobilePhoneNumber(String mobilePhoneNumber);

    User findByEmail(String email);

    @Query("from UserOrganizationJob where user=?1 and organizationId=?2 and jobId=?3")
    UserOrganizationJob findUserOrganization(User user, Long organizationId, Long jobId);


    @Query("select uoj from UserOrganizationJob uoj where not exists(select 1 from Job j where uoj.jobId=j.id) or not exists(select 1 from Organization o where uoj.organizationId=o.id)")
    Page<UserOrganizationJob> findUserOrganizationJobOnNotExistsOrganizationOrJob(Pageable pageable);

    @Modifying
    @Query("delete from UserOrganizationJob uoj where not exists(select 1 from User u where uoj.user=u)")
    void deleteUserOrganizationJobOnNotExistsUser();
}
