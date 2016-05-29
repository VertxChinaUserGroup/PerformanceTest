package io.vertx.test.io;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import util.TestUtil;

/**
 * Default IO is HttpServerVerticle.
 * @author yz
 * @date 5/18/16
 */
public class HttpServerVerticle extends AbstractVerticle {

  private static final String RESPONSE_TYPE_PLAIN = "text/plain";
  private static final String HEADER_CONTENT = "content-type";
  private static final String CONTENT_LENGTH = "Content-Length";

  private HttpServer server;

  @Override
  public void start() {
    int port = 8080;
    String host = "127.0.0.1";
    server = vertx.createHttpServer();
    server.requestHandler(handle()).listen(port, host);
  }

  public Handler<HttpServerRequest> handle() {
    return request -> {
      handlePlainText(request, request.path());
    };
  }

  @Override
  public void stop(){
    if ( server != null ) server.close();
  }

  private void handlePlainText(HttpServerRequest request, String responseMsg) {
    request.response()
        .putHeader(HEADER_CONTENT, RESPONSE_TYPE_PLAIN)
        .end(TestUtil.MSG_MAPPER.get(responseMsg));
  }

  public static void main(String[] args) {
    int procs = Runtime.getRuntime().availableProcessors();
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(HttpServerVerticle.class.getName(),
        new DeploymentOptions().setInstances(procs*2), event -> {
          if (event.succeeded()) {
            System.out.println("Success listen 8080");
          } else {
            System.out.println("Failure listen 8080");
            event.cause().printStackTrace();
          }
        });
  }
}
