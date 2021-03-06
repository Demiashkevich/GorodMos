package com.dzemiashkevich.gorodmos.parse.configuration;

import org.apache.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.SocketTimeoutException;

public final class JsoupConnecter {

    private static final Logger logger = Logger.getLogger(JsoupConnecter.class);

    private static double timeout = 1_000;

    public static Document getDocumentByUrl(final String url) {
        Connection connect = Jsoup.connect(url);
        Document document;
        for(;;) {
            document = getConnect(connect);
            if (document != null) {
                break;
            }
        }
        timeout = 1_000;
        return document;
    }

    private static Document getConnect(final Connection connect) {
        Document document = null;
        try {
            document = connect.timeout((int)timeout).get();
        } catch (SocketTimeoutException e) {
            timeout = Math.exp(timeout / 1_000) * 1_000;
            logger.info("Server connection delay time:" + timeout);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

}