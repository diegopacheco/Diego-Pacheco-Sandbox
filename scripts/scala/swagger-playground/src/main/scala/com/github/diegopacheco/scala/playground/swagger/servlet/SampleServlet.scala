package com.github.diegopacheco.scala.playground.swagger.servlet

import com.wordnik.swagger.annotations._

import com.wordnik.swagger.core.util.JsonSerializer

import java.io.IOException
import java.text.SimpleDateFormat

import javax.servlet.ServletException
import javax.servlet.http.{ HttpServlet, HttpServletRequest, HttpServletResponse }

case class SampleData (id: Long, name: String, email: String, age: Int, dateOfBirth: java.util.Date)
case class ApiResponseScala (code: Int, message: String)

@Api(value = "/sample/users", description = "gets some data from a servlet")
class SampleServlet extends HttpServlet {
  
  val dateFormat = new SimpleDateFormat("dd-MM-yyyy")
  
  @throws(classOf[IOException])
  @throws(classOf[ServletException])
  @ApiOperation(httpMethod = "GET", value = "Resource to get a user", response = classOf[SampleData], nickname="getUser")
  @ApiResponses(Array(new ApiResponse(code = 400, message = "Invalid input", response = classOf[ApiResponse])))
  @ApiImplicitParams(Array(
    new ApiImplicitParam(name = "name", value = "User's name", required = true, dataType = "string", paramType = "query"),
    new ApiImplicitParam(name = "email", value = "User's email", required = true, dataType = "string", paramType = "query"),
    new ApiImplicitParam(name = "id", value = "User ID", required = true, dataType = "long", paramType = "query"),
    new ApiImplicitParam(name = "age", value = "User ID", required = true, dataType = "long", paramType = "query"),
    new ApiImplicitParam(name = "dateOfBirth", value = "User's date of birth, in dd-MM-yyyy format", required = true, dataType = "Date", paramType = "query")))
  override protected def doGet(request: HttpServletRequest, response: HttpServletResponse) = {
    response.setContentType("application/json")
    try {
      val id = request.getParameter("id").toLong
      val name = request.getParameter("name")
      val age = request.getParameter("age").toInt
      val email = request.getParameter("email")
      val dateOfBirth = dateFormat.parse(request.getParameter("dateOfBirth"))
      response.getOutputStream.write(JsonSerializer.asJson(SampleData(id, name, email, age, dateOfBirth)).getBytes("utf-8"))
    }
    catch {
      case e: Exception => response.getOutputStream.write(JsonSerializer.asJson(ApiResponseScala(400, e.getMessage)).getBytes("utf-8"))
    }
  }
}