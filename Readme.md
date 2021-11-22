url serveur : https://shorturl-332716.oa.r.appspot.com

Use case :

    - Get all short url - GET Method
    https://shorturl-332716.oa.r.appspot.com/short_url

    - Get one short url - GET Method
    https://shorturl-332716.oa.r.appspot.com/short_url/{id}

    - Create short url. - POST Method
    https://shorturl-332716.oa.r.appspot.com/short_url
    Body must contains json structure with attribute "url"

    - Delete short url. - DELETE Method 
    https://shorturl-332716.oa.r.appspot.com/short_url/{id}

    - Use short url
    https://shorturl-332716.oa.r.appspot.com/{short_url}

---

For this project I used a template for the creation of springboot application for appengine.
In the project I used spring classes for persistence because of simplicity.
There are many method for current sql request, and we can simply add new one
with name normalization.

For the architecture, I separated the layer service and the layer repository because 
of possible business rules.

I create an interface for entity even if there is not really useful but 
it allows to consider future standardization.

In the same way, I create personalized exception. 

For the test I used Junit5 because of possibility to ordered method execution.
