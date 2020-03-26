# Spring-Boot-Cache-project

Cache is one of the nice features of the spring boot. Caching is a temporary storage mechanism between persistent storage and application. 
It reduces the number of database hits. Caching improves the application’s performance by reducing network connectivity and
loading the database.

Spring boot uses annotations to allow the application to cache. Spring boot enables caching with the help of minimum configuration. 
We will show how caching can be configured and how the cache works in the spring boot.

In the pom.xml file, add spring boot cache dependency “spring-boot-starter-cache” module.

The next step is to enable cache by adding annotation @EnableCaching to the main method.

Add @Cacheable annotation to the cached method.

To clear the cache, the @CacheEvict annotation is used. After clearing the cache, the method will be invoked and cached next time.

The spring boot application should begin by enabling cache. So add annotation @enablecache before the main method.

Add @cachable annotation before the caching methods. The following example shows how to add annotation @cachable.

StudentController is a rest controller class that can be invoked from the browser. This controller class has three method,
the first method is not cache configured, it works like normal rest call. The second method is cache configured, 
it returns cache data. To remove the cache, the third method is used.

The next step is to call the browser’s url http://localhost:8080/studentwithcache. This url is cache configured. 
This url invokes the method for the first time. It sends answers from the cache from the next time. This url is called three 
times here, but in the console window it shows log only once.

Call the remove cache url http://localhost:8080/remove from the browser. This url removes the student object from the cache. 
The log displays the cache removal of object in the console

Now call the browser again to the url http://localhost:8080/studentwithcache. This time, log is displayed to invoke the cache-configured method.
window.
