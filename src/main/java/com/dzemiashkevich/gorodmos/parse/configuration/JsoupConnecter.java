package com.dzemiashkevich.gorodmos.parse.configuration;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.SocketTimeoutException;

public final class JsoupConnecter {

  private static int timeout = 1_000;

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
      document = connect.timeout(timeout).get();
    } catch (SocketTimeoutException e) {
      timeout += 1_000;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return document;
  }

  //    JBrowserDriver driver = new JBrowserDriver(
//          Settings
//              .builder()
//              .timezone(Timezone.AMERICA_NEWYORK)
//              .ajaxWait(20 * 1000)
//              .build());
//      driver.get(url);
//      return driver.getPageSource();

}
