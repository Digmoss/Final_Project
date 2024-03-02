import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class MyLoadTest extends Simulation {
  val httpConf = http.baseUrl("http://localhost:8080/Avi_Eden_Noam_May/Project.jsp")
    .header("Accept", "application/json")

  val scn = scenario("Test_Avi_Noam_Eden_May")
    .exec(http("RequestName")
      .get("/yourEndpoint")
      .check(status.is(200)))
    .pause(5)

  setUp(
    scn.inject(
      rampConcurrentUsers(0) to (90) during (4 minutes)
    )
  ).protocols(httpConf)
}
