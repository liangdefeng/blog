## Getting an OAuth Token
curl -v -d "grant_type=password&username=admin&password=admin" -H "Content-Type: application/x-www-form-urlencoded;charset=UTF-8" -H "Authorization: Basic Y2xpZW50OnNlY3JldA==" -X POST http://localhost:8080/app/rest/v2/oauth/token
curl -v -d "grant_type=password&username=admin&password=admin" -H "Content-Type: application/x-www-form-urlencoded;charset=UTF-8" -H "Authorization: Basic Y2xpZW50OnNlY3JldA==" -X POST http://localhost:8080/app/rest/v2/oauth/token
curl -v -d "grant_type=password&username=editor&password=1" -H "Content-Type: application/x-www-form-urlencoded;charset=UTF-8" -H "Authorization: Basic Y2xpZW50OnNlY3JldA==" -X POST http://localhost:8080/app/rest/v2/oauth/token

## Getting an Entity Instances List
curl -v -H "Authorization: Bearer 5623dbac-174d-4fb0-b593-acccfb69d401" -X GET http://localhost:8080/app/rest/v2/entities/blog_Article

## Service Method Invocation (POST)
curl -v -d '{"markDown":"abcd"}' -H "Content-Type: application/json" -H "Authorization: Bearer 5623dbac-174d-4fb0-b593-acccfb69d401" -X POST http://localhost:8080/app/rest/v2/services/blog_MarkdownService/toHtml
