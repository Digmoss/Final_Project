import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class LoadTestSimulation extends Simulation {

  val httpConf = http.baseUrl("http://localhost:8080/Avi_Eden_Noam_May/Project.jsp")

  val scn = scenario("Avi_Eden_Noam_May")
    .during(4 minutes) {
      exec(http("Request")
        .get("/"))
      .pause(1)
    }

  setUp(scn.inject(atOnceUsers(90)).protocols(httpConf))
}
