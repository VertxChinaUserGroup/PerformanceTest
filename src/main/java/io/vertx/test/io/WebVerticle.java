package io.vertx.test.io;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import util.TestUtil;

import io.vertx.ext.web.Router;

/**
 * @author yz
 * @date 5/18/16
 */
public class WebVerticle extends AbstractVerticle {

  private static final String RESPONSE_TYPE_PLAIN = "text/plain";
  private static final String HEADER_CONTENT = "content-type";
  private static final String CONTENT_LENGTH = "Content-Length";

  private HttpServer server;

  @Override
  public void start() {
    int port = 8080;
    String host = "127.0.0.1";
    server = vertx.createHttpServer();
    Router route = Router.router(vertx);

    route.route().handler(routeContext -> {
      routeContext.response()
          .putHeader(HEADER_CONTENT, RESPONSE_TYPE_PLAIN)
          .end(TestUtil.MSG_MAPPER.get(routeContext.request().uri()));
    });

    server.requestHandler(route::accept).listen(port, host);
  }

  @Override
  public void stop(){
    if ( server != null ) server.close();
  }

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    int procs = Runtime.getRuntime().availableProcessors();
    vertx.deployVerticle(WebVerticle.class.getName(),
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
