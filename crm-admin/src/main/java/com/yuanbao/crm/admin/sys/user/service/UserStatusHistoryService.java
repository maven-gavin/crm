package com.yuanbao.crm.admin.sys.user.service;

import com.yuanbao.crm.admin.sys.user.entity.User;
import com.yuanbao.crm.admin.sys.user.entity.UserStatus;
import com.yuanbao.crm.admin.sys.user.entity.UserStatusHistory;
import com.yuanbao.crm.common.entity.search.Searchable;
import com.yuanbao.crm.common.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by gewen on 2017/1/21.
 */
@Service
public class UserStatusHistoryService extends BaseService<UserStatusHistory, Long> {

    public void log(User opUser, User user, UserStatus newStatus, String reason) {
        UserStatusHistory history = new UserStatusHistory();
        history.setUser(user);
        history.setOpUser(opUser);
        history.setOpDate(new Date());
        history.setStatus(newStatus);
        history.setReason(reason);
        save(history);
    }

    public UserStatusHistory findLastHistory(final User user) {
        Searchable searchable = Searchable.newSearchable()
                .addSearchParam("user_eq", user)
                .addSort(Sort.Direction.DESC, "opDate")
                .setPage(0, 1);

        Page<UserStatusHistory> page = baseRepository.findAll(searchable);

        if (page.hasContent()) {
            return page.getContent().get(0);
        }
        return null;
    }

    public String getLastReason(User user) {
        UserStatusHistory history = findLastHistory(user);
        if (history == null) {
            return "";
        }
        return history.getReason();
    }
}