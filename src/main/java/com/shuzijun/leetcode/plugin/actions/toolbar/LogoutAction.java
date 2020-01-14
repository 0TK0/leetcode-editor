package com.shuzijun.leetcode.plugin.actions.toolbar;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.shuzijun.leetcode.plugin.actions.AbstractAsynAction;
import com.shuzijun.leetcode.plugin.model.Config;
import com.shuzijun.leetcode.plugin.utils.HttpClientUtils;
import com.shuzijun.leetcode.plugin.utils.MessageUtils;
import com.shuzijun.leetcode.plugin.utils.PropertiesUtils;
import com.shuzijun.leetcode.plugin.utils.URLUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

/**
 * @author shuzijun
 */
public class LogoutAction extends AbstractAsynAction {
    @Override
    public void perform(AnActionEvent anActionEvent, Config config) {

        HttpGet httpget = new HttpGet(URLUtils.getLeetcodeLogout());
        CloseableHttpResponse response = HttpClientUtils.executeGet(httpget);
        httpget.abort();
        HttpClientUtils.resetHttpclient();
        MessageUtils.getInstance(anActionEvent.getProject()).showInfoMsg("info", PropertiesUtils.getInfo("login.out"));
    }
}
