
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class Avi_Eden_Noam_May extends Simulation {

  private val httpProtocol = http
    .baseUrl("http://localhost:8080")
    .inferHtmlResources()
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("en-US,en;q=0.9,he;q=0.8,he-IL;q=0.7")
    .contentTypeHeader("application/x-www-form-urlencoded")
    .originHeader("http://localhost:8080")
    .upgradeInsecureRequestsHeader("1")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36")
  
  private val headers_0 = Map(
  		"Cache-Control" -> "max-age=0",
  		"Sec-Fetch-Dest" -> "document",
  		"Sec-Fetch-Mode" -> "navigate",
  		"Sec-Fetch-Site" -> "same-origin",
  		"Sec-Fetch-User" -> "?1",
  		"sec-ch-ua" -> """Chromium";v="122", "Not(A:Brand";v="24", "Google Chrome";v="122""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "Windows"
  )


  private val scn = scenario("DevopsProjectSimulation")
    .exec(
      http("request_0")
        .post("/Avi_Eden_Noam_May/Project.jsp")
        .headers(headers_0)
        .formParam("username", "Avi")
        .formParam("action", "Submit Name"),
      pause(21),
      http("request_1")
        .post("/Avi_Eden_Noam_May/Project.jsp")
        .headers(headers_0)
        .formParam("username", "Eden")
        .formParam("action", "Say Hello"),
      pause(14),
      http("request_2")
        .post("/Avi_Eden_Noam_May/Project.jsp")
        .headers(headers_0)
        .formParam("username", "1234")
        .formParam("action", "Submit Name"),
      pause(33),
      http("request_3")
        .post("/Avi_Eden_Noam_May/Project.jsp")
        .headers(headers_0)
        .formParam("username", "Noam!")
        .formParam("action", "Submit Name"),
      pause(51),
      http("request_4")
        .post("/Avi_Eden_Noam_May/Project.jsp")
        .headers(headers_0)
        .formParam("username", "May.")
        .formParam("action", "Say Hello")
    )

	setUp(scn.inject(constantConcurrentUsers(90) during (4 minutes))).protocols(httpProtocol)
}
