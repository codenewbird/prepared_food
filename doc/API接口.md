### 接口---通过梧桐链SDK进行存证和获取存证信息
#### 创建存证交易
接口调用请求说明
```
http请求方式: post
http://<host>:<port>/store
```
参数说明
|参数|是否必要|说明|类型|
|---|---|---|---|
|Data|是|存证内容，json类型编码后再存入|string|
|Pubkeys|否|相关方公钥，可指定多个，公钥格式为base64字串|String Array|

请求体举例
```json
{
"Data": "any data"，
"pubkeys": 
["LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS1NRmt3RXdZSEtvWkl6ajBDQVFZSUtvR
WN6MVVCZ2kwRFFnQUVYVVo1dG1NdXk0aTl0WVhma1QwTXl6dWI5VnJpDQo0N
VRlUHZWeFFEbWxPN2YxWHY0TzZvYXRyVkJvZjR1dkJPZmVBbVNEMmJ0UGFWNDN
BbUs0WEg1Sy9BPT0NCi0tLS0tRU5EIFBVQkxJQyBLRVktLS0tLQ=="]
}
```

正常返回说明
```json
{
    "State": 200,
    "Message": "success",
    "Data": {
        "Figure": "YrqQNWNeOJv/gfb2tmgfdbO9hT0LdLP/Y5H6Da2H6OI=",
        "OK": true
    }
}
```
错误返回说明
```json
{
    "State":400,
    "Message":
    "Invalid parameter, error:json: cannot unmarshal object into Go struct field .Data of type string",
    "Data":null
}
```

#### 查询存证交易
接口调用请求说明
```
http请求方式: get
http://<host>:<port>/getstore?hash=urlEncode(区块哈希值)
```
参数说明
|参数|是否必要|说明|类型|
|---|---|---|---|
|hash|是|创建存证交易接口返回的Data.Figure，区块哈希值|string|


返回说明
```json
{
    "State": 200,
    "Message": "success",
    "Data": "eyJwcm9kdWN0aW9uX2JhdGNoZXMiOiIxMjMiLCJuYW1lIjoi6aOf55So5rK5IiwibWFudWZhY3R1cmVyIjoiWFhY6YWN5paZ5YWs5Y+4IiwiZG9zYWdlIjo1MDAuMCwibWFudWZhY3R1cmVfZGF0ZSI6MTY5ODgyMTIyMjcyMn0="
}
```