## Output

```text
.   ____          _            __ _ _
/\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
\\/  ___)| |_)| | | | | || (_| |  ) ) ) )
'  |____| .__|_| |_|_| |_\__, | / / / /
=========|_|==============|___/=/_/_/_/
:: Spring Boot ::                (v3.0.2)

2023-02-01T00:37:00.428+03:00  INFO 14400 --- [           main] c.e.weatherapi.WeatherApiApplication     : Starting WeatherApiApplication using Java 17.0.2 with PID 14400 (C:\Users\Emin\Desktop\Java\DefineXPracticum\WeatherAPI\target\classes started by Emin in C:\Users\Emin\Desktop\Java\DefineXPracticum\WeatherAPI)
2023-02-01T00:37:00.432+03:00  INFO 14400 --- [           main] c.e.weatherapi.WeatherApiApplication     : No active profile set, falling back to 1 default profile: "default"
2023-02-01T00:37:01.414+03:00  INFO 14400 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2023-02-01T00:37:01.421+03:00  INFO 14400 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-02-01T00:37:01.421+03:00  INFO 14400 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.5]
2023-02-01T00:37:01.491+03:00  INFO 14400 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-02-01T00:37:01.491+03:00  INFO 14400 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1002 ms
2023-02-01T00:37:01.889+03:00  INFO 14400 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-02-01T00:37:01.898+03:00  INFO 14400 --- [           main] c.e.weatherapi.WeatherApiApplication     : Started WeatherApiApplication in 1.826 seconds (process running for 2.332)
2023-02-01T00:37:05.111+03:00  INFO 14400 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2023-02-01T00:37:05.111+03:00  INFO 14400 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2023-02-01T00:37:05.113+03:00  INFO 14400 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 2 ms
2023-02-01T00:37:05.161+03:00 ERROR 14400 --- [nio-8080-exec-1] c.e.w.e.handler.WeatherExceptionHandler  : Error occurred during the request: {"message":"Required request body is missing: public org.springframework.http.ResponseEntity<?> com.eminyilmazz.weatherapi.controller.WeatherController.getCurrent(com.eminyilmazz.weatherapi.entity.CurrentRequest,org.springframework.validation.BindingResult) throws com.fasterxml.jackson.core.JsonProcessingException"}
2023-02-01T00:37:30.067+03:00  INFO 14400 --- [nio-8080-exec-4] c.e.w.i.RestTemplateInterceptor          : Getting weather info for city: istanbull
2023-02-01T00:37:30.416+03:00  INFO 14400 --- [nio-8080-exec-4] c.e.w.i.RestTemplateInterceptor          : Received response with status code: 400 BAD_REQUEST and headers: [Date:"Tue, 31 Jan 2023 21:37:31 GMT", Content-Type:"application/json", Transfer-Encoding:"chunked", Connection:"keep-alive", Server:"BunnyCDN-DE1-1082", CDN-PullZone:"93447", CDN-Uid:"8fa3a04a-75d9-4707-8056-b7b33c8ac7fe", CDN-RequestCountryCode:"TR", Cache-Control:"public, max-age=5", CDN-ProxyVer:"1.03", CDN-RequestPullSuccess:"True", CDN-RequestPullCode:"400", CDN-CachedAt:"01/31/2023 21:37:31", CDN-EdgeStorageId:"1047", CDN-Status:"400", CDN-RequestId:"137cd696cc72b6ff5b3502e5d2d79535", CDN-Cache:"MISS"]
2023-02-01T00:37:30.422+03:00 ERROR 14400 --- [nio-8080-exec-4] c.e.w.e.handler.WeatherExceptionHandler  : Error occurred during the request: {"message":"400 Bad Request: \"{\"error\":{\"code\":1006,\"message\":\"No matching location found.\"}}\""}
2023-02-01T00:37:35.027+03:00 ERROR 14400 --- [nio-8080-exec-6] c.e.w.controller.WeatherController       : Request has invalid variables. city :  - City cannot be blank!
2023-02-01T00:37:44.161+03:00  INFO 14400 --- [nio-8080-exec-9] c.e.w.i.RestTemplateInterceptor          : Getting weather info for city: istanbul
2023-02-01T00:37:44.300+03:00  INFO 14400 --- [nio-8080-exec-9] c.e.w.i.RestTemplateInterceptor          : Received response with status code: 200 OK and headers: [Date:"Tue, 31 Jan 2023 21:37:45 GMT", Content-Type:"application/json", Transfer-Encoding:"chunked", Connection:"keep-alive", Vary:"Accept-Encoding", Server:"BunnyCDN-DE1-1082", CDN-PullZone:"93447", CDN-Uid:"8fa3a04a-75d9-4707-8056-b7b33c8ac7fe", CDN-RequestCountryCode:"TR", Cache-Control:"public, max-age=180", CDN-ProxyVer:"1.03", CDN-RequestPullSuccess:"True", CDN-RequestPullCode:"200", CDN-CachedAt:"01/31/2023 21:37:45", CDN-EdgeStorageId:"865", CDN-Status:"200", CDN-RequestId:"f7b6ff9fc68d1d5ab3c176f5d1a4f231", CDN-Cache:"MISS"]
2023-02-01T00:37:56.519+03:00 ERROR 14400 --- [nio-8080-exec-8] c.e.w.e.handler.WeatherExceptionHandler  : Error occurred during the request: {"message":"Required request body is missing: public org.springframework.http.ResponseEntity<?> com.eminyilmazz.weatherapi.controller.WeatherController.getForecast(com.eminyilmazz.weatherapi.entity.ForecastRequest,org.springframework.validation.BindingResult) throws com.fasterxml.jackson.core.JsonProcessingException"}
2023-02-01T00:38:03.803+03:00 ERROR 14400 --- [nio-8080-exec-3] c.e.w.controller.WeatherController       : Request has invalid variables. days : null - Days count cannot be null for forecast request.
2023-02-01T00:38:09.718+03:00 ERROR 14400 --- [nio-8080-exec-2] c.e.w.controller.WeatherController       : Request has invalid variables. days : 15 - Days count must be less than or equal to 14.
2023-02-01T00:38:13.913+03:00 ERROR 14400 --- [nio-8080-exec-5] c.e.w.controller.WeatherController       : Request has invalid variables. days : -1 - Days count must be more than or equal to 1.
2023-02-01T00:38:20.558+03:00 ERROR 14400 --- [nio-8080-exec-7] c.e.w.controller.WeatherController       : Request has invalid variables. days : 15 - Days count must be less than or equal to 14.
2023-02-01T00:38:25.423+03:00 ERROR 14400 --- [nio-8080-exec-8] c.e.w.controller.WeatherController       : Request has invalid variables. city : null - City cannot be blank!
2023-02-01T00:38:30.630+03:00 ERROR 14400 --- [io-8080-exec-10] c.e.w.controller.WeatherController       : Request has invalid variables. days : 15 - Days count must be less than or equal to 14.
2023-02-01T00:38:40.144+03:00  INFO 14400 --- [nio-8080-exec-2] c.e.w.i.RestTemplateInterceptor          : Getting weather info for 13 days.
2023-02-01T00:38:40.144+03:00  INFO 14400 --- [nio-8080-exec-2] c.e.w.i.RestTemplateInterceptor          : Getting weather info for city: istanbul
2023-02-01T00:38:40.410+03:00  INFO 14400 --- [nio-8080-exec-2] c.e.w.i.RestTemplateInterceptor          : Received response with status code: 200 OK and headers: [Date:"Tue, 31 Jan 2023 21:38:41 GMT", Content-Type:"application/json", Transfer-Encoding:"chunked", Connection:"keep-alive", Vary:"Accept-Encoding", Server:"BunnyCDN-DE1-1081", CDN-PullZone:"93447", CDN-Uid:"8fa3a04a-75d9-4707-8056-b7b33c8ac7fe", CDN-RequestCountryCode:"TR", Cache-Control:"public, max-age=180", CDN-ProxyVer:"1.03", CDN-RequestPullSuccess:"True", CDN-RequestPullCode:"200", CDN-CachedAt:"01/31/2023 21:38:41", CDN-EdgeStorageId:"863", CDN-Status:"200", CDN-RequestId:"b40d803ec0c9d89836f9994de1b8a093", CDN-Cache:"MISS"]
```