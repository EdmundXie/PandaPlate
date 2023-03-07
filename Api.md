# PandaPlate


**Description**:PandaPlate


**HOST**:localhost:7070


**Contacts**:


**Version**:1.0


**URL**:/v2/api-docs


[TOC]






# address-book-controller


## saveAddress


**url**:`/addressBook`


**method**:`POST`


**produces**:`application/json`


**consumes**:`*/*`


**Note**:


**Example**:


```javascript
{
  "cityCode": "",
  "cityName": "",
  "consignee": "",
  "createTime": "",
  "createUser": 0,
  "detail": "",
  "districtCode": "",
  "districtName": "",
  "id": 0,
  "isDefault": 0,
  "isDeleted": 0,
  "label": "",
  "phone": "",
  "provinceCode": "",
  "provinceName": "",
  "sex": "",
  "updateTime": "",
  "updateUser": 0,
  "userId": 0
}
```


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|addressBook|addressBook|body|true|AddressBook|AddressBook|
|&emsp;&emsp;cityCode|||false|string||
|&emsp;&emsp;cityName|||false|string||
|&emsp;&emsp;consignee|||false|string||
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;createUser|||false|integer(int64)||
|&emsp;&emsp;detail|||false|string||
|&emsp;&emsp;districtCode|||false|string||
|&emsp;&emsp;districtName|||false|string||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;isDefault|||false|integer(int32)||
|&emsp;&emsp;isDeleted|||false|integer(int32)||
|&emsp;&emsp;label|||false|string||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;provinceCode|||false|string||
|&emsp;&emsp;provinceName|||false|string||
|&emsp;&emsp;sex|||false|string||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;updateUser|||false|integer(int64)||
|&emsp;&emsp;userId|||false|integer(int64)||
|creationTime||query|false|integer(int64)||
|id||query|false|string||
|lastAccessedTime||query|false|integer(int64)||
|maxInactiveInterval||query|false|integer(int32)||
|new||query|false|boolean||
|valueNames||query|false|array|string|


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## updateAddress


**url**:`/addressBook`


**method**:`PUT`


**produces**:`application/json`


**consumes**:`*/*`


**Note**:


**Example**:


```javascript
{
  "cityCode": "",
  "cityName": "",
  "consignee": "",
  "createTime": "",
  "createUser": 0,
  "detail": "",
  "districtCode": "",
  "districtName": "",
  "id": 0,
  "isDefault": 0,
  "isDeleted": 0,
  "label": "",
  "phone": "",
  "provinceCode": "",
  "provinceName": "",
  "sex": "",
  "updateTime": "",
  "updateUser": 0,
  "userId": 0
}
```


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|addressBook|addressBook|body|true|AddressBook|AddressBook|
|&emsp;&emsp;cityCode|||false|string||
|&emsp;&emsp;cityName|||false|string||
|&emsp;&emsp;consignee|||false|string||
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;createUser|||false|integer(int64)||
|&emsp;&emsp;detail|||false|string||
|&emsp;&emsp;districtCode|||false|string||
|&emsp;&emsp;districtName|||false|string||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;isDefault|||false|integer(int32)||
|&emsp;&emsp;isDeleted|||false|integer(int32)||
|&emsp;&emsp;label|||false|string||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;provinceCode|||false|string||
|&emsp;&emsp;provinceName|||false|string||
|&emsp;&emsp;sex|||false|string||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;updateUser|||false|integer(int64)||
|&emsp;&emsp;userId|||false|integer(int64)||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## getDefault


**url**:`/addressBook/default`


**method**:`GET`


**produces**:`application/x-www-form-urlencoded`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|creationTime||query|false|integer(int64)||
|id||query|false|string||
|lastAccessedTime||query|false|integer(int64)||
|maxInactiveInterval||query|false|integer(int32)||
|new||query|false|boolean||
|valueNames||query|false|array|string|


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«AddressBook»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||AddressBook|AddressBook|
|&emsp;&emsp;cityCode||string||
|&emsp;&emsp;cityName||string||
|&emsp;&emsp;consignee||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;createUser||integer(int64)||
|&emsp;&emsp;detail||string||
|&emsp;&emsp;districtCode||string||
|&emsp;&emsp;districtName||string||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;isDefault||integer(int32)||
|&emsp;&emsp;isDeleted||integer(int32)||
|&emsp;&emsp;label||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;provinceCode||string||
|&emsp;&emsp;provinceName||string||
|&emsp;&emsp;sex||string||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;updateUser||integer(int64)||
|&emsp;&emsp;userId||integer(int64)||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": {
		"cityCode": "",
		"cityName": "",
		"consignee": "",
		"createTime": "",
		"createUser": 0,
		"detail": "",
		"districtCode": "",
		"districtName": "",
		"id": 0,
		"isDefault": 0,
		"isDeleted": 0,
		"label": "",
		"phone": "",
		"provinceCode": "",
		"provinceName": "",
		"sex": "",
		"updateTime": "",
		"updateUser": 0,
		"userId": 0
	},
	"map": {},
	"msg": ""
}
```


## setDefault


**url**:`/addressBook/default`


**method**:`PUT`


**produces**:`application/json`


**consumes**:`*/*`


**Note**:


**Example**:


```javascript
{
  "cityCode": "",
  "cityName": "",
  "consignee": "",
  "createTime": "",
  "createUser": 0,
  "detail": "",
  "districtCode": "",
  "districtName": "",
  "id": 0,
  "isDefault": 0,
  "isDeleted": 0,
  "label": "",
  "phone": "",
  "provinceCode": "",
  "provinceName": "",
  "sex": "",
  "updateTime": "",
  "updateUser": 0,
  "userId": 0
}
```


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|addressBook|addressBook|body|true|AddressBook|AddressBook|
|&emsp;&emsp;cityCode|||false|string||
|&emsp;&emsp;cityName|||false|string||
|&emsp;&emsp;consignee|||false|string||
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;createUser|||false|integer(int64)||
|&emsp;&emsp;detail|||false|string||
|&emsp;&emsp;districtCode|||false|string||
|&emsp;&emsp;districtName|||false|string||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;isDefault|||false|integer(int32)||
|&emsp;&emsp;isDeleted|||false|integer(int32)||
|&emsp;&emsp;label|||false|string||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;provinceCode|||false|string||
|&emsp;&emsp;provinceName|||false|string||
|&emsp;&emsp;sex|||false|string||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;updateUser|||false|integer(int64)||
|&emsp;&emsp;userId|||false|integer(int64)||
|creationTime||query|false|integer(int64)||
|id||query|false|string||
|lastAccessedTime||query|false|integer(int64)||
|maxInactiveInterval||query|false|integer(int32)||
|new||query|false|boolean||
|valueNames||query|false|array|string|


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«AddressBook»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||AddressBook|AddressBook|
|&emsp;&emsp;cityCode||string||
|&emsp;&emsp;cityName||string||
|&emsp;&emsp;consignee||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;createUser||integer(int64)||
|&emsp;&emsp;detail||string||
|&emsp;&emsp;districtCode||string||
|&emsp;&emsp;districtName||string||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;isDefault||integer(int32)||
|&emsp;&emsp;isDeleted||integer(int32)||
|&emsp;&emsp;label||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;provinceCode||string||
|&emsp;&emsp;provinceName||string||
|&emsp;&emsp;sex||string||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;updateUser||integer(int64)||
|&emsp;&emsp;userId||integer(int64)||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": {
		"cityCode": "",
		"cityName": "",
		"consignee": "",
		"createTime": "",
		"createUser": 0,
		"detail": "",
		"districtCode": "",
		"districtName": "",
		"id": 0,
		"isDefault": 0,
		"isDeleted": 0,
		"label": "",
		"phone": "",
		"provinceCode": "",
		"provinceName": "",
		"sex": "",
		"updateTime": "",
		"updateUser": 0,
		"userId": 0
	},
	"map": {},
	"msg": ""
}
```


## getList


**url**:`/addressBook/list`


**method**:`GET`


**produces**:`application/x-www-form-urlencoded`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|creationTime||query|false|integer(int64)||
|id||query|false|string||
|lastAccessedTime||query|false|integer(int64)||
|maxInactiveInterval||query|false|integer(int32)||
|new||query|false|boolean||
|valueNames||query|false|array|string|


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«List«AddressBook»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||array|AddressBook|
|&emsp;&emsp;cityCode||string||
|&emsp;&emsp;cityName||string||
|&emsp;&emsp;consignee||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;createUser||integer(int64)||
|&emsp;&emsp;detail||string||
|&emsp;&emsp;districtCode||string||
|&emsp;&emsp;districtName||string||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;isDefault||integer(int32)||
|&emsp;&emsp;isDeleted||integer(int32)||
|&emsp;&emsp;label||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;provinceCode||string||
|&emsp;&emsp;provinceName||string||
|&emsp;&emsp;sex||string||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;updateUser||integer(int64)||
|&emsp;&emsp;userId||integer(int64)||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": [
		{
			"cityCode": "",
			"cityName": "",
			"consignee": "",
			"createTime": "",
			"createUser": 0,
			"detail": "",
			"districtCode": "",
			"districtName": "",
			"id": 0,
			"isDefault": 0,
			"isDeleted": 0,
			"label": "",
			"phone": "",
			"provinceCode": "",
			"provinceName": "",
			"sex": "",
			"updateTime": "",
			"updateUser": 0,
			"userId": 0
		}
	],
	"map": {},
	"msg": ""
}
```


## getAddress


**url**:`/addressBook/{id}`


**method**:`GET`


**produces**:`application/x-www-form-urlencoded`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|integer(int64)||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«AddressBook»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||AddressBook|AddressBook|
|&emsp;&emsp;cityCode||string||
|&emsp;&emsp;cityName||string||
|&emsp;&emsp;consignee||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;createUser||integer(int64)||
|&emsp;&emsp;detail||string||
|&emsp;&emsp;districtCode||string||
|&emsp;&emsp;districtName||string||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;isDefault||integer(int32)||
|&emsp;&emsp;isDeleted||integer(int32)||
|&emsp;&emsp;label||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;provinceCode||string||
|&emsp;&emsp;provinceName||string||
|&emsp;&emsp;sex||string||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;updateUser||integer(int64)||
|&emsp;&emsp;userId||integer(int64)||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": {
		"cityCode": "",
		"cityName": "",
		"consignee": "",
		"createTime": "",
		"createUser": 0,
		"detail": "",
		"districtCode": "",
		"districtName": "",
		"id": 0,
		"isDefault": 0,
		"isDeleted": 0,
		"label": "",
		"phone": "",
		"provinceCode": "",
		"provinceName": "",
		"sex": "",
		"updateTime": "",
		"updateUser": 0,
		"userId": 0
	},
	"map": {},
	"msg": ""
}
```


# category-controller


## addCategory


**url**:`/category`


**method**:`POST`


**produces**:`application/json`


**consumes**:`*/*`


**Note**:


**Example**:


```javascript
{
  "createTime": "",
  "createUser": 0,
  "id": 0,
  "name": "",
  "sort": 0,
  "type": 0,
  "updateTime": "",
  "updateUser": 0
}
```


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|category|category|body|true|Category|Category|
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;createUser|||false|integer(int64)||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;sort|||false|integer(int32)||
|&emsp;&emsp;type|||false|integer(int32)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;updateUser|||false|integer(int64)||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## updateCategory


**url**:`/category`


**method**:`PUT`


**produces**:`application/json`


**consumes**:`*/*`


**Note**:


**Example**:


```javascript
{
  "createTime": "",
  "createUser": 0,
  "id": 0,
  "name": "",
  "sort": 0,
  "type": 0,
  "updateTime": "",
  "updateUser": 0
}
```


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|category|category|body|true|Category|Category|
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;createUser|||false|integer(int64)||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;sort|||false|integer(int32)||
|&emsp;&emsp;type|||false|integer(int32)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;updateUser|||false|integer(int64)||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## deleteCategory


**url**:`/category`


**method**:`DELETE`


**produces**:`application/x-www-form-urlencoded`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|ids|ids|query|false|integer(int64)||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## getList


**url**:`/category/list`


**method**:`GET`


**produces**:`application/x-www-form-urlencoded`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|createTime||query|false|string(date-time)||
|createUser||query|false|integer(int64)||
|id||query|false|integer(int64)||
|name||query|false|string||
|sort||query|false|integer(int32)||
|type||query|false|integer(int32)||
|updateTime||query|false|string(date-time)||
|updateUser||query|false|integer(int64)||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«List«Category»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||array|Category|
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;createUser||integer(int64)||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;name||string||
|&emsp;&emsp;sort||integer(int32)||
|&emsp;&emsp;type||integer(int32)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;updateUser||integer(int64)||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": [
		{
			"createTime": "",
			"createUser": 0,
			"id": 0,
			"name": "",
			"sort": 0,
			"type": 0,
			"updateTime": "",
			"updateUser": 0
		}
	],
	"map": {},
	"msg": ""
}
```


## categoryPage


**url**:`/category/page`


**method**:`GET`


**produces**:`application/x-www-form-urlencoded`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|page|page|query|false|integer(int32)||
|pageSize|pageSize|query|false|integer(int32)||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«Page»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||Page|Page|
|&emsp;&emsp;countId||string||
|&emsp;&emsp;current||integer(int64)||
|&emsp;&emsp;hitCount||boolean||
|&emsp;&emsp;maxLimit||integer(int64)||
|&emsp;&emsp;optimizeCountSql||boolean||
|&emsp;&emsp;orders||array|OrderItem|
|&emsp;&emsp;&emsp;&emsp;asc||boolean||
|&emsp;&emsp;&emsp;&emsp;column||string||
|&emsp;&emsp;pages||integer(int64)||
|&emsp;&emsp;records||array|object|
|&emsp;&emsp;searchCount||boolean||
|&emsp;&emsp;size||integer(int64)||
|&emsp;&emsp;total||integer(int64)||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": {
		"countId": "",
		"current": 0,
		"hitCount": true,
		"maxLimit": 0,
		"optimizeCountSql": true,
		"orders": [
			{
				"asc": true,
				"column": ""
			}
		],
		"pages": 0,
		"records": [],
		"searchCount": true,
		"size": 0,
		"total": 0
	},
	"map": {},
	"msg": ""
}
```


# common-controller


## download


**url**:`/common/download`


**method**:`GET`


**produces**:`application/x-www-form-urlencoded`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|name|name|query|false|string||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


None


**Response Example**:
```javascript

```


## upload


**url**:`/common/upload`


**method**:`POST`


**produces**:`multipart/form-data`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|file||formData|false|file||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


# dish-controller


## save


**url**:`/dish`


**method**:`POST`


**produces**:`application/json`


**consumes**:`*/*`


**Note**:


**Example**:


```javascript
{
  "categoryId": 0,
  "categoryName": "",
  "code": "",
  "copies": 0,
  "createTime": "",
  "createUser": 0,
  "description": "",
  "flavors": [
    {
      "createTime": "",
      "createUser": 0,
      "dishId": 0,
      "id": 0,
      "isDeleted": 0,
      "name": "",
      "updateTime": "",
      "updateUser": 0,
      "value": ""
    }
  ],
  "id": 0,
  "image": "",
  "isDeleted": 0,
  "name": "",
  "price": 0,
  "sort": 0,
  "status": 0,
  "updateTime": "",
  "updateUser": 0
}
```


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|dishDto|dishDto|body|true|DishDto|DishDto|
|&emsp;&emsp;categoryId|||false|integer(int64)||
|&emsp;&emsp;categoryName|||false|string||
|&emsp;&emsp;code|||false|string||
|&emsp;&emsp;copies|||false|integer(int32)||
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;createUser|||false|integer(int64)||
|&emsp;&emsp;description|||false|string||
|&emsp;&emsp;flavors|||false|array|DishFlavor|
|&emsp;&emsp;&emsp;&emsp;createTime|||false|string||
|&emsp;&emsp;&emsp;&emsp;createUser|||false|integer||
|&emsp;&emsp;&emsp;&emsp;dishId|||false|integer||
|&emsp;&emsp;&emsp;&emsp;id|||false|integer||
|&emsp;&emsp;&emsp;&emsp;isDeleted|||false|integer||
|&emsp;&emsp;&emsp;&emsp;name|||false|string||
|&emsp;&emsp;&emsp;&emsp;updateTime|||false|string||
|&emsp;&emsp;&emsp;&emsp;updateUser|||false|integer||
|&emsp;&emsp;&emsp;&emsp;value|||false|string||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;image|||false|string||
|&emsp;&emsp;isDeleted|||false|integer(int32)||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;price|||false|number||
|&emsp;&emsp;sort|||false|integer(int32)||
|&emsp;&emsp;status|||false|integer(int32)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;updateUser|||false|integer(int64)||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## update


**url**:`/dish`


**method**:`PUT`


**produces**:`application/json`


**consumes**:`*/*`


**Note**:


**Example**:


```javascript
{
  "categoryId": 0,
  "categoryName": "",
  "code": "",
  "copies": 0,
  "createTime": "",
  "createUser": 0,
  "description": "",
  "flavors": [
    {
      "createTime": "",
      "createUser": 0,
      "dishId": 0,
      "id": 0,
      "isDeleted": 0,
      "name": "",
      "updateTime": "",
      "updateUser": 0,
      "value": ""
    }
  ],
  "id": 0,
  "image": "",
  "isDeleted": 0,
  "name": "",
  "price": 0,
  "sort": 0,
  "status": 0,
  "updateTime": "",
  "updateUser": 0
}
```


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|dishDto|dishDto|body|true|DishDto|DishDto|
|&emsp;&emsp;categoryId|||false|integer(int64)||
|&emsp;&emsp;categoryName|||false|string||
|&emsp;&emsp;code|||false|string||
|&emsp;&emsp;copies|||false|integer(int32)||
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;createUser|||false|integer(int64)||
|&emsp;&emsp;description|||false|string||
|&emsp;&emsp;flavors|||false|array|DishFlavor|
|&emsp;&emsp;&emsp;&emsp;createTime|||false|string||
|&emsp;&emsp;&emsp;&emsp;createUser|||false|integer||
|&emsp;&emsp;&emsp;&emsp;dishId|||false|integer||
|&emsp;&emsp;&emsp;&emsp;id|||false|integer||
|&emsp;&emsp;&emsp;&emsp;isDeleted|||false|integer||
|&emsp;&emsp;&emsp;&emsp;name|||false|string||
|&emsp;&emsp;&emsp;&emsp;updateTime|||false|string||
|&emsp;&emsp;&emsp;&emsp;updateUser|||false|integer||
|&emsp;&emsp;&emsp;&emsp;value|||false|string||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;image|||false|string||
|&emsp;&emsp;isDeleted|||false|integer(int32)||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;price|||false|number||
|&emsp;&emsp;sort|||false|integer(int32)||
|&emsp;&emsp;status|||false|integer(int32)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;updateUser|||false|integer(int64)||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## delete


**url**:`/dish`


**method**:`DELETE`


**produces**:`application/x-www-form-urlencoded`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|ids|ids|query|false|array|integer|


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## list


**url**:`/dish/list`


**method**:`GET`


**produces**:`application/x-www-form-urlencoded`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|categoryId||query|false|integer(int64)||
|code||query|false|string||
|createTime||query|false|string(date-time)||
|createUser||query|false|integer(int64)||
|description||query|false|string||
|id||query|false|integer(int64)||
|image||query|false|string||
|isDeleted||query|false|integer(int32)||
|name||query|false|string||
|price||query|false|number||
|sort||query|false|integer(int32)||
|status||query|false|integer(int32)||
|updateTime||query|false|string(date-time)||
|updateUser||query|false|integer(int64)||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«List«DishDto»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||array|DishDto|
|&emsp;&emsp;categoryId||integer(int64)||
|&emsp;&emsp;categoryName||string||
|&emsp;&emsp;code||string||
|&emsp;&emsp;copies||integer(int32)||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;createUser||integer(int64)||
|&emsp;&emsp;description||string||
|&emsp;&emsp;flavors||array|DishFlavor|
|&emsp;&emsp;&emsp;&emsp;createTime||string||
|&emsp;&emsp;&emsp;&emsp;createUser||integer||
|&emsp;&emsp;&emsp;&emsp;dishId||integer||
|&emsp;&emsp;&emsp;&emsp;id||integer||
|&emsp;&emsp;&emsp;&emsp;isDeleted||integer||
|&emsp;&emsp;&emsp;&emsp;name||string||
|&emsp;&emsp;&emsp;&emsp;updateTime||string||
|&emsp;&emsp;&emsp;&emsp;updateUser||integer||
|&emsp;&emsp;&emsp;&emsp;value||string||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;image||string||
|&emsp;&emsp;isDeleted||integer(int32)||
|&emsp;&emsp;name||string||
|&emsp;&emsp;price||number||
|&emsp;&emsp;sort||integer(int32)||
|&emsp;&emsp;status||integer(int32)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;updateUser||integer(int64)||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": [
		{
			"categoryId": 0,
			"categoryName": "",
			"code": "",
			"copies": 0,
			"createTime": "",
			"createUser": 0,
			"description": "",
			"flavors": [
				{
					"createTime": "",
					"createUser": 0,
					"dishId": 0,
					"id": 0,
					"isDeleted": 0,
					"name": "",
					"updateTime": "",
					"updateUser": 0,
					"value": ""
				}
			],
			"id": 0,
			"image": "",
			"isDeleted": 0,
			"name": "",
			"price": 0,
			"sort": 0,
			"status": 0,
			"updateTime": "",
			"updateUser": 0
		}
	],
	"map": {},
	"msg": ""
}
```


## dishPage


**url**:`/dish/page`


**method**:`GET`


**produces**:`application/x-www-form-urlencoded`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|name|name|query|false|string||
|page|page|query|false|integer(int32)||
|pageSize|pageSize|query|false|integer(int32)||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«Page»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||Page|Page|
|&emsp;&emsp;countId||string||
|&emsp;&emsp;current||integer(int64)||
|&emsp;&emsp;hitCount||boolean||
|&emsp;&emsp;maxLimit||integer(int64)||
|&emsp;&emsp;optimizeCountSql||boolean||
|&emsp;&emsp;orders||array|OrderItem|
|&emsp;&emsp;&emsp;&emsp;asc||boolean||
|&emsp;&emsp;&emsp;&emsp;column||string||
|&emsp;&emsp;pages||integer(int64)||
|&emsp;&emsp;records||array|object|
|&emsp;&emsp;searchCount||boolean||
|&emsp;&emsp;size||integer(int64)||
|&emsp;&emsp;total||integer(int64)||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": {
		"countId": "",
		"current": 0,
		"hitCount": true,
		"maxLimit": 0,
		"optimizeCountSql": true,
		"orders": [
			{
				"asc": true,
				"column": ""
			}
		],
		"pages": 0,
		"records": [],
		"searchCount": true,
		"size": 0,
		"total": 0
	},
	"map": {},
	"msg": ""
}
```


## saleStatus


**url**:`/dish/status/{status}`


**method**:`POST`


**produces**:`application/json`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|status|status|path|true|integer(int32)||
|ids|ids|query|false|array|integer|


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## getInfo


**url**:`/dish/{id}`


**method**:`GET`


**produces**:`application/x-www-form-urlencoded`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|integer(int64)||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«DishDto»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||DishDto|DishDto|
|&emsp;&emsp;categoryId||integer(int64)||
|&emsp;&emsp;categoryName||string||
|&emsp;&emsp;code||string||
|&emsp;&emsp;copies||integer(int32)||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;createUser||integer(int64)||
|&emsp;&emsp;description||string||
|&emsp;&emsp;flavors||array|DishFlavor|
|&emsp;&emsp;&emsp;&emsp;createTime||string||
|&emsp;&emsp;&emsp;&emsp;createUser||integer||
|&emsp;&emsp;&emsp;&emsp;dishId||integer||
|&emsp;&emsp;&emsp;&emsp;id||integer||
|&emsp;&emsp;&emsp;&emsp;isDeleted||integer||
|&emsp;&emsp;&emsp;&emsp;name||string||
|&emsp;&emsp;&emsp;&emsp;updateTime||string||
|&emsp;&emsp;&emsp;&emsp;updateUser||integer||
|&emsp;&emsp;&emsp;&emsp;value||string||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;image||string||
|&emsp;&emsp;isDeleted||integer(int32)||
|&emsp;&emsp;name||string||
|&emsp;&emsp;price||number||
|&emsp;&emsp;sort||integer(int32)||
|&emsp;&emsp;status||integer(int32)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;updateUser||integer(int64)||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": {
		"categoryId": 0,
		"categoryName": "",
		"code": "",
		"copies": 0,
		"createTime": "",
		"createUser": 0,
		"description": "",
		"flavors": [
			{
				"createTime": "",
				"createUser": 0,
				"dishId": 0,
				"id": 0,
				"isDeleted": 0,
				"name": "",
				"updateTime": "",
				"updateUser": 0,
				"value": ""
			}
		],
		"id": 0,
		"image": "",
		"isDeleted": 0,
		"name": "",
		"price": 0,
		"sort": 0,
		"status": 0,
		"updateTime": "",
		"updateUser": 0
	},
	"map": {},
	"msg": ""
}
```


# employee-controller


## addEmployee


**url**:`/employee`


**method**:`POST`


**produces**:`application/json`


**consumes**:`*/*`


**Note**:


**Example**:


```javascript
{
  "createTime": "",
  "createUser": 0,
  "id": 0,
  "idNumber": "",
  "name": "",
  "password": "",
  "phone": "",
  "sex": "",
  "status": 0,
  "updateTime": "",
  "updateUser": 0,
  "username": ""
}
```


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|employee|employee|body|true|Employee|Employee|
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;createUser|||false|integer(int64)||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;idNumber|||false|string||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;password|||false|string||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;sex|||false|string||
|&emsp;&emsp;status|||false|integer(int32)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;updateUser|||false|integer(int64)||
|&emsp;&emsp;username|||false|string||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## update


**url**:`/employee`


**method**:`PUT`


**produces**:`application/json`


**consumes**:`*/*`


**Note**:


**Example**:


```javascript
{
  "createTime": "",
  "createUser": 0,
  "id": 0,
  "idNumber": "",
  "name": "",
  "password": "",
  "phone": "",
  "sex": "",
  "status": 0,
  "updateTime": "",
  "updateUser": 0,
  "username": ""
}
```


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|employee|employee|body|true|Employee|Employee|
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;createUser|||false|integer(int64)||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;idNumber|||false|string||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;password|||false|string||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;sex|||false|string||
|&emsp;&emsp;status|||false|integer(int32)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;updateUser|||false|integer(int64)||
|&emsp;&emsp;username|||false|string||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## login


**url**:`/employee/login`


**method**:`POST`


**produces**:`application/json`


**consumes**:`*/*`


**Note**:


**Example**:


```javascript
{
  "createTime": "",
  "createUser": 0,
  "id": 0,
  "idNumber": "",
  "name": "",
  "password": "",
  "phone": "",
  "sex": "",
  "status": 0,
  "updateTime": "",
  "updateUser": 0,
  "username": ""
}
```


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|employee|employee|body|true|Employee|Employee|
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;createUser|||false|integer(int64)||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;idNumber|||false|string||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;password|||false|string||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;sex|||false|string||
|&emsp;&emsp;status|||false|integer(int32)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;updateUser|||false|integer(int64)||
|&emsp;&emsp;username|||false|string||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«Employee»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||Employee|Employee|
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;createUser||integer(int64)||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;idNumber||string||
|&emsp;&emsp;name||string||
|&emsp;&emsp;password||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;sex||string||
|&emsp;&emsp;status||integer(int32)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;updateUser||integer(int64)||
|&emsp;&emsp;username||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": {
		"createTime": "",
		"createUser": 0,
		"id": 0,
		"idNumber": "",
		"name": "",
		"password": "",
		"phone": "",
		"sex": "",
		"status": 0,
		"updateTime": "",
		"updateUser": 0,
		"username": ""
	},
	"map": {},
	"msg": ""
}
```


## logout


**url**:`/employee/logout`


**method**:`POST`


**produces**:`application/json`


**consumes**:`*/*`


**Note**:


**Params**:


暂无


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## page


**url**:`/employee/page`


**method**:`GET`


**produces**:`application/x-www-form-urlencoded`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|name|name|query|false|string||
|page|page|query|false|integer(int32)||
|pageSize|pageSize|query|false|integer(int32)||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«Page»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||Page|Page|
|&emsp;&emsp;countId||string||
|&emsp;&emsp;current||integer(int64)||
|&emsp;&emsp;hitCount||boolean||
|&emsp;&emsp;maxLimit||integer(int64)||
|&emsp;&emsp;optimizeCountSql||boolean||
|&emsp;&emsp;orders||array|OrderItem|
|&emsp;&emsp;&emsp;&emsp;asc||boolean||
|&emsp;&emsp;&emsp;&emsp;column||string||
|&emsp;&emsp;pages||integer(int64)||
|&emsp;&emsp;records||array|object|
|&emsp;&emsp;searchCount||boolean||
|&emsp;&emsp;size||integer(int64)||
|&emsp;&emsp;total||integer(int64)||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": {
		"countId": "",
		"current": 0,
		"hitCount": true,
		"maxLimit": 0,
		"optimizeCountSql": true,
		"orders": [
			{
				"asc": true,
				"column": ""
			}
		],
		"pages": 0,
		"records": [],
		"searchCount": true,
		"size": 0,
		"total": 0
	},
	"map": {},
	"msg": ""
}
```


## getById


**url**:`/employee/{id}`


**method**:`GET`


**produces**:`application/x-www-form-urlencoded`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|integer(int64)||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«Employee»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||Employee|Employee|
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;createUser||integer(int64)||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;idNumber||string||
|&emsp;&emsp;name||string||
|&emsp;&emsp;password||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;sex||string||
|&emsp;&emsp;status||integer(int32)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;updateUser||integer(int64)||
|&emsp;&emsp;username||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": {
		"createTime": "",
		"createUser": 0,
		"id": 0,
		"idNumber": "",
		"name": "",
		"password": "",
		"phone": "",
		"sex": "",
		"status": 0,
		"updateTime": "",
		"updateUser": 0,
		"username": ""
	},
	"map": {},
	"msg": ""
}
```


# order-controller


## update


**url**:`/order`


**method**:`PUT`


**produces**:`application/json`


**consumes**:`*/*`


**Note**:


**Example**:


```javascript
{
  "address": "",
  "addressBookId": 0,
  "amount": 0,
  "checkoutTime": "",
  "consignee": "",
  "id": 0,
  "number": "",
  "orderTime": "",
  "payMethod": 0,
  "phone": "",
  "remark": "",
  "status": 0,
  "userId": 0,
  "userName": ""
}
```


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|orders|orders|body|true|Orders|Orders|
|&emsp;&emsp;address|||false|string||
|&emsp;&emsp;addressBookId|||false|integer(int64)||
|&emsp;&emsp;amount|||false|number||
|&emsp;&emsp;checkoutTime|||false|string(date-time)||
|&emsp;&emsp;consignee|||false|string||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;number|||false|string||
|&emsp;&emsp;orderTime|||false|string(date-time)||
|&emsp;&emsp;payMethod|||false|integer(int32)||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;remark|||false|string||
|&emsp;&emsp;status|||false|integer(int32)||
|&emsp;&emsp;userId|||false|integer(int64)||
|&emsp;&emsp;userName|||false|string||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## orderAgain


**url**:`/order/again`


**method**:`POST`


**produces**:`application/json`


**consumes**:`*/*`


**Note**:


**Example**:


```javascript
{
  "address": "",
  "addressBookId": 0,
  "amount": 0,
  "checkoutTime": "",
  "consignee": "",
  "id": 0,
  "number": "",
  "orderTime": "",
  "payMethod": 0,
  "phone": "",
  "remark": "",
  "status": 0,
  "userId": 0,
  "userName": ""
}
```


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|orders|orders|body|true|Orders|Orders|
|&emsp;&emsp;address|||false|string||
|&emsp;&emsp;addressBookId|||false|integer(int64)||
|&emsp;&emsp;amount|||false|number||
|&emsp;&emsp;checkoutTime|||false|string(date-time)||
|&emsp;&emsp;consignee|||false|string||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;number|||false|string||
|&emsp;&emsp;orderTime|||false|string(date-time)||
|&emsp;&emsp;payMethod|||false|integer(int32)||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;remark|||false|string||
|&emsp;&emsp;status|||false|integer(int32)||
|&emsp;&emsp;userId|||false|integer(int64)||
|&emsp;&emsp;userName|||false|string||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## backendPage


**url**:`/order/page`


**method**:`GET`


**produces**:`application/x-www-form-urlencoded`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|beginTime|beginTime|query|false|string||
|endTime|endTime|query|false|string||
|number|number|query|false|string||
|page|page|query|false|integer(int32)||
|pageSize|pageSize|query|false|integer(int32)||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«Page»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||Page|Page|
|&emsp;&emsp;countId||string||
|&emsp;&emsp;current||integer(int64)||
|&emsp;&emsp;hitCount||boolean||
|&emsp;&emsp;maxLimit||integer(int64)||
|&emsp;&emsp;optimizeCountSql||boolean||
|&emsp;&emsp;orders||array|OrderItem|
|&emsp;&emsp;&emsp;&emsp;asc||boolean||
|&emsp;&emsp;&emsp;&emsp;column||string||
|&emsp;&emsp;pages||integer(int64)||
|&emsp;&emsp;records||array|object|
|&emsp;&emsp;searchCount||boolean||
|&emsp;&emsp;size||integer(int64)||
|&emsp;&emsp;total||integer(int64)||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": {
		"countId": "",
		"current": 0,
		"hitCount": true,
		"maxLimit": 0,
		"optimizeCountSql": true,
		"orders": [
			{
				"asc": true,
				"column": ""
			}
		],
		"pages": 0,
		"records": [],
		"searchCount": true,
		"size": 0,
		"total": 0
	},
	"map": {},
	"msg": ""
}
```


## submitOrder


**url**:`/order/submit`


**method**:`POST`


**produces**:`application/json`


**consumes**:`*/*`


**Note**:


**Example**:


```javascript
{
  "address": "",
  "addressBookId": 0,
  "amount": 0,
  "checkoutTime": "",
  "consignee": "",
  "id": 0,
  "number": "",
  "orderTime": "",
  "payMethod": 0,
  "phone": "",
  "remark": "",
  "status": 0,
  "userId": 0,
  "userName": ""
}
```


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|orders|orders|body|true|Orders|Orders|
|&emsp;&emsp;address|||false|string||
|&emsp;&emsp;addressBookId|||false|integer(int64)||
|&emsp;&emsp;amount|||false|number||
|&emsp;&emsp;checkoutTime|||false|string(date-time)||
|&emsp;&emsp;consignee|||false|string||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;number|||false|string||
|&emsp;&emsp;orderTime|||false|string(date-time)||
|&emsp;&emsp;payMethod|||false|integer(int32)||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;remark|||false|string||
|&emsp;&emsp;status|||false|integer(int32)||
|&emsp;&emsp;userId|||false|integer(int64)||
|&emsp;&emsp;userName|||false|string||
|creationTime||query|false|integer(int64)||
|id||query|false|string||
|lastAccessedTime||query|false|integer(int64)||
|maxInactiveInterval||query|false|integer(int32)||
|new||query|false|boolean||
|valueNames||query|false|array|string|


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## getPage


**url**:`/order/userPage`


**method**:`GET`


**produces**:`application/x-www-form-urlencoded`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|creationTime||query|false|integer(int64)||
|id||query|false|string||
|lastAccessedTime||query|false|integer(int64)||
|maxInactiveInterval||query|false|integer(int32)||
|new||query|false|boolean||
|page|page|query|false|integer(int32)||
|pageSize|pageSize|query|false|integer(int32)||
|valueNames||query|false|array|string|


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«Page»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||Page|Page|
|&emsp;&emsp;countId||string||
|&emsp;&emsp;current||integer(int64)||
|&emsp;&emsp;hitCount||boolean||
|&emsp;&emsp;maxLimit||integer(int64)||
|&emsp;&emsp;optimizeCountSql||boolean||
|&emsp;&emsp;orders||array|OrderItem|
|&emsp;&emsp;&emsp;&emsp;asc||boolean||
|&emsp;&emsp;&emsp;&emsp;column||string||
|&emsp;&emsp;pages||integer(int64)||
|&emsp;&emsp;records||array|object|
|&emsp;&emsp;searchCount||boolean||
|&emsp;&emsp;size||integer(int64)||
|&emsp;&emsp;total||integer(int64)||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": {
		"countId": "",
		"current": 0,
		"hitCount": true,
		"maxLimit": 0,
		"optimizeCountSql": true,
		"orders": [
			{
				"asc": true,
				"column": ""
			}
		],
		"pages": 0,
		"records": [],
		"searchCount": true,
		"size": 0,
		"total": 0
	},
	"map": {},
	"msg": ""
}
```


# setmeal-controller


## add


**url**:`/setmeal`


**method**:`POST`


**produces**:`application/json`


**consumes**:`*/*`


**Note**:


**Example**:


```javascript
{
  "categoryId": 0,
  "categoryName": "",
  "code": "",
  "createTime": "",
  "createUser": 0,
  "description": "",
  "id": 0,
  "image": "",
  "isDeleted": 0,
  "name": "",
  "price": 0,
  "setmealDishes": [
    {
      "copies": 0,
      "createTime": "",
      "createUser": 0,
      "dishId": 0,
      "id": 0,
      "isDeleted": 0,
      "name": "",
      "price": 0,
      "setmealId": 0,
      "sort": 0,
      "updateTime": "",
      "updateUser": 0
    }
  ],
  "status": 0,
  "updateTime": "",
  "updateUser": 0
}
```


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|setmealDto|setmealDto|body|true|SetmealDto|SetmealDto|
|&emsp;&emsp;categoryId|||false|integer(int64)||
|&emsp;&emsp;categoryName|||false|string||
|&emsp;&emsp;code|||false|string||
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;createUser|||false|integer(int64)||
|&emsp;&emsp;description|||false|string||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;image|||false|string||
|&emsp;&emsp;isDeleted|||false|integer(int32)||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;price|||false|number||
|&emsp;&emsp;setmealDishes|||false|array|SetmealDish|
|&emsp;&emsp;&emsp;&emsp;copies|||false|integer||
|&emsp;&emsp;&emsp;&emsp;createTime|||false|string||
|&emsp;&emsp;&emsp;&emsp;createUser|||false|integer||
|&emsp;&emsp;&emsp;&emsp;dishId|||false|integer||
|&emsp;&emsp;&emsp;&emsp;id|||false|integer||
|&emsp;&emsp;&emsp;&emsp;isDeleted|||false|integer||
|&emsp;&emsp;&emsp;&emsp;name|||false|string||
|&emsp;&emsp;&emsp;&emsp;price|||false|number||
|&emsp;&emsp;&emsp;&emsp;setmealId|||false|integer||
|&emsp;&emsp;&emsp;&emsp;sort|||false|integer||
|&emsp;&emsp;&emsp;&emsp;updateTime|||false|string||
|&emsp;&emsp;&emsp;&emsp;updateUser|||false|integer||
|&emsp;&emsp;status|||false|integer(int32)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;updateUser|||false|integer(int64)||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## update


**url**:`/setmeal`


**method**:`PUT`


**produces**:`application/json`


**consumes**:`*/*`


**Note**:


**Example**:


```javascript
{
  "categoryId": 0,
  "categoryName": "",
  "code": "",
  "createTime": "",
  "createUser": 0,
  "description": "",
  "id": 0,
  "image": "",
  "isDeleted": 0,
  "name": "",
  "price": 0,
  "setmealDishes": [
    {
      "copies": 0,
      "createTime": "",
      "createUser": 0,
      "dishId": 0,
      "id": 0,
      "isDeleted": 0,
      "name": "",
      "price": 0,
      "setmealId": 0,
      "sort": 0,
      "updateTime": "",
      "updateUser": 0
    }
  ],
  "status": 0,
  "updateTime": "",
  "updateUser": 0
}
```


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|setmealDto|setmealDto|body|true|SetmealDto|SetmealDto|
|&emsp;&emsp;categoryId|||false|integer(int64)||
|&emsp;&emsp;categoryName|||false|string||
|&emsp;&emsp;code|||false|string||
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;createUser|||false|integer(int64)||
|&emsp;&emsp;description|||false|string||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;image|||false|string||
|&emsp;&emsp;isDeleted|||false|integer(int32)||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;price|||false|number||
|&emsp;&emsp;setmealDishes|||false|array|SetmealDish|
|&emsp;&emsp;&emsp;&emsp;copies|||false|integer||
|&emsp;&emsp;&emsp;&emsp;createTime|||false|string||
|&emsp;&emsp;&emsp;&emsp;createUser|||false|integer||
|&emsp;&emsp;&emsp;&emsp;dishId|||false|integer||
|&emsp;&emsp;&emsp;&emsp;id|||false|integer||
|&emsp;&emsp;&emsp;&emsp;isDeleted|||false|integer||
|&emsp;&emsp;&emsp;&emsp;name|||false|string||
|&emsp;&emsp;&emsp;&emsp;price|||false|number||
|&emsp;&emsp;&emsp;&emsp;setmealId|||false|integer||
|&emsp;&emsp;&emsp;&emsp;sort|||false|integer||
|&emsp;&emsp;&emsp;&emsp;updateTime|||false|string||
|&emsp;&emsp;&emsp;&emsp;updateUser|||false|integer||
|&emsp;&emsp;status|||false|integer(int32)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;updateUser|||false|integer(int64)||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## delete


**url**:`/setmeal`


**method**:`DELETE`


**produces**:`application/x-www-form-urlencoded`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|ids|ids|query|false|array|integer|


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## getList


**url**:`/setmeal/list`


**method**:`GET`


**produces**:`application/x-www-form-urlencoded`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|categoryId|categoryId|query|false|integer(int64)||
|status|status|query|false|integer(int32)||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«List«Setmeal»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||array|Setmeal|
|&emsp;&emsp;categoryId||integer(int64)||
|&emsp;&emsp;code||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;createUser||integer(int64)||
|&emsp;&emsp;description||string||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;image||string||
|&emsp;&emsp;isDeleted||integer(int32)||
|&emsp;&emsp;name||string||
|&emsp;&emsp;price||number||
|&emsp;&emsp;status||integer(int32)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;updateUser||integer(int64)||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": [
		{
			"categoryId": 0,
			"code": "",
			"createTime": "",
			"createUser": 0,
			"description": "",
			"id": 0,
			"image": "",
			"isDeleted": 0,
			"name": "",
			"price": 0,
			"status": 0,
			"updateTime": "",
			"updateUser": 0
		}
	],
	"map": {},
	"msg": ""
}
```


## getPage


**url**:`/setmeal/page`


**method**:`GET`


**produces**:`application/x-www-form-urlencoded`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|name|name|query|false|string||
|page|page|query|false|integer(int32)||
|pageSize|pageSize|query|false|integer(int32)||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«Page»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||Page|Page|
|&emsp;&emsp;countId||string||
|&emsp;&emsp;current||integer(int64)||
|&emsp;&emsp;hitCount||boolean||
|&emsp;&emsp;maxLimit||integer(int64)||
|&emsp;&emsp;optimizeCountSql||boolean||
|&emsp;&emsp;orders||array|OrderItem|
|&emsp;&emsp;&emsp;&emsp;asc||boolean||
|&emsp;&emsp;&emsp;&emsp;column||string||
|&emsp;&emsp;pages||integer(int64)||
|&emsp;&emsp;records||array|object|
|&emsp;&emsp;searchCount||boolean||
|&emsp;&emsp;size||integer(int64)||
|&emsp;&emsp;total||integer(int64)||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": {
		"countId": "",
		"current": 0,
		"hitCount": true,
		"maxLimit": 0,
		"optimizeCountSql": true,
		"orders": [
			{
				"asc": true,
				"column": ""
			}
		],
		"pages": 0,
		"records": [],
		"searchCount": true,
		"size": 0,
		"total": 0
	},
	"map": {},
	"msg": ""
}
```


## saleSatus


**url**:`/setmeal/status/{status}`


**method**:`POST`


**produces**:`application/json`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|status|status|path|true|integer(int32)||
|ids|ids|query|false|array|integer|


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## getInfo


**url**:`/setmeal/{id}`


**method**:`GET`


**produces**:`application/x-www-form-urlencoded`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|integer(int64)||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«SetmealDto»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||SetmealDto|SetmealDto|
|&emsp;&emsp;categoryId||integer(int64)||
|&emsp;&emsp;categoryName||string||
|&emsp;&emsp;code||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;createUser||integer(int64)||
|&emsp;&emsp;description||string||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;image||string||
|&emsp;&emsp;isDeleted||integer(int32)||
|&emsp;&emsp;name||string||
|&emsp;&emsp;price||number||
|&emsp;&emsp;setmealDishes||array|SetmealDish|
|&emsp;&emsp;&emsp;&emsp;copies||integer||
|&emsp;&emsp;&emsp;&emsp;createTime||string||
|&emsp;&emsp;&emsp;&emsp;createUser||integer||
|&emsp;&emsp;&emsp;&emsp;dishId||integer||
|&emsp;&emsp;&emsp;&emsp;id||integer||
|&emsp;&emsp;&emsp;&emsp;isDeleted||integer||
|&emsp;&emsp;&emsp;&emsp;name||string||
|&emsp;&emsp;&emsp;&emsp;price||number||
|&emsp;&emsp;&emsp;&emsp;setmealId||integer||
|&emsp;&emsp;&emsp;&emsp;sort||integer||
|&emsp;&emsp;&emsp;&emsp;updateTime||string||
|&emsp;&emsp;&emsp;&emsp;updateUser||integer||
|&emsp;&emsp;status||integer(int32)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;updateUser||integer(int64)||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": {
		"categoryId": 0,
		"categoryName": "",
		"code": "",
		"createTime": "",
		"createUser": 0,
		"description": "",
		"id": 0,
		"image": "",
		"isDeleted": 0,
		"name": "",
		"price": 0,
		"setmealDishes": [
			{
				"copies": 0,
				"createTime": "",
				"createUser": 0,
				"dishId": 0,
				"id": 0,
				"isDeleted": 0,
				"name": "",
				"price": 0,
				"setmealId": 0,
				"sort": 0,
				"updateTime": "",
				"updateUser": 0
			}
		],
		"status": 0,
		"updateTime": "",
		"updateUser": 0
	},
	"map": {},
	"msg": ""
}
```


# shopping-cart-controller


## addItem


**url**:`/shoppingCart/add`


**method**:`POST`


**produces**:`application/json`


**consumes**:`*/*`


**Note**:


**Example**:


```javascript
{
  "amount": 0,
  "createTime": "",
  "dishFlavor": "",
  "dishId": 0,
  "id": 0,
  "image": "",
  "name": "",
  "number": 0,
  "setmealId": 0,
  "userId": 0
}
```


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|shoppingCart|shoppingCart|body|true|ShoppingCart|ShoppingCart|
|&emsp;&emsp;amount|||false|number||
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;dishFlavor|||false|string||
|&emsp;&emsp;dishId|||false|integer(int64)||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;image|||false|string||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;number|||false|integer(int32)||
|&emsp;&emsp;setmealId|||false|integer(int64)||
|&emsp;&emsp;userId|||false|integer(int64)||
|creationTime||query|false|integer(int64)||
|id||query|false|string||
|lastAccessedTime||query|false|integer(int64)||
|maxInactiveInterval||query|false|integer(int32)||
|new||query|false|boolean||
|valueNames||query|false|array|string|


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«ShoppingCart»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||ShoppingCart|ShoppingCart|
|&emsp;&emsp;amount||number||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;dishFlavor||string||
|&emsp;&emsp;dishId||integer(int64)||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;image||string||
|&emsp;&emsp;name||string||
|&emsp;&emsp;number||integer(int32)||
|&emsp;&emsp;setmealId||integer(int64)||
|&emsp;&emsp;userId||integer(int64)||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": {
		"amount": 0,
		"createTime": "",
		"dishFlavor": "",
		"dishId": 0,
		"id": 0,
		"image": "",
		"name": "",
		"number": 0,
		"setmealId": 0,
		"userId": 0
	},
	"map": {},
	"msg": ""
}
```


## clean


**url**:`/shoppingCart/clean`


**method**:`DELETE`


**produces**:`application/x-www-form-urlencoded`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|creationTime||query|false|integer(int64)||
|id||query|false|string||
|lastAccessedTime||query|false|integer(int64)||
|maxInactiveInterval||query|false|integer(int32)||
|new||query|false|boolean||
|valueNames||query|false|array|string|


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## getList


**url**:`/shoppingCart/list`


**method**:`GET`


**produces**:`application/x-www-form-urlencoded`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|creationTime||query|false|integer(int64)||
|id||query|false|string||
|lastAccessedTime||query|false|integer(int64)||
|maxInactiveInterval||query|false|integer(int32)||
|new||query|false|boolean||
|valueNames||query|false|array|string|


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«List«ShoppingCart»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||array|ShoppingCart|
|&emsp;&emsp;amount||number||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;dishFlavor||string||
|&emsp;&emsp;dishId||integer(int64)||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;image||string||
|&emsp;&emsp;name||string||
|&emsp;&emsp;number||integer(int32)||
|&emsp;&emsp;setmealId||integer(int64)||
|&emsp;&emsp;userId||integer(int64)||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": [
		{
			"amount": 0,
			"createTime": "",
			"dishFlavor": "",
			"dishId": 0,
			"id": 0,
			"image": "",
			"name": "",
			"number": 0,
			"setmealId": 0,
			"userId": 0
		}
	],
	"map": {},
	"msg": ""
}
```


## subItem


**url**:`/shoppingCart/sub`


**method**:`POST`


**produces**:`application/json`


**consumes**:`*/*`


**Note**:


**Example**:


```javascript
{
  "amount": 0,
  "createTime": "",
  "dishFlavor": "",
  "dishId": 0,
  "id": 0,
  "image": "",
  "name": "",
  "number": 0,
  "setmealId": 0,
  "userId": 0
}
```


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|shoppingCart|shoppingCart|body|true|ShoppingCart|ShoppingCart|
|&emsp;&emsp;amount|||false|number||
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;dishFlavor|||false|string||
|&emsp;&emsp;dishId|||false|integer(int64)||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;image|||false|string||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;number|||false|integer(int32)||
|&emsp;&emsp;setmealId|||false|integer(int64)||
|&emsp;&emsp;userId|||false|integer(int64)||


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«ShoppingCart»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||ShoppingCart|ShoppingCart|
|&emsp;&emsp;amount||number||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;dishFlavor||string||
|&emsp;&emsp;dishId||integer(int64)||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;image||string||
|&emsp;&emsp;name||string||
|&emsp;&emsp;number||integer(int32)||
|&emsp;&emsp;setmealId||integer(int64)||
|&emsp;&emsp;userId||integer(int64)||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": {
		"amount": 0,
		"createTime": "",
		"dishFlavor": "",
		"dishId": 0,
		"id": 0,
		"image": "",
		"name": "",
		"number": 0,
		"setmealId": 0,
		"userId": 0
	},
	"map": {},
	"msg": ""
}
```


# user-controller


## login


**url**:`/user/login`


**method**:`POST`


**produces**:`application/json`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|userMap|userMap|body|true|object||
|creationTime||query|false|integer(int64)||
|id||query|false|string||
|lastAccessedTime||query|false|integer(int64)||
|maxInactiveInterval||query|false|integer(int32)||
|new||query|false|boolean||
|valueNames||query|false|array|string|


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«User»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||User|User|
|&emsp;&emsp;avatar||string||
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;idNumber||string||
|&emsp;&emsp;name||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;sex||string||
|&emsp;&emsp;status||integer(int32)||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": {
		"avatar": "",
		"id": 0,
		"idNumber": "",
		"name": "",
		"phone": "",
		"sex": "",
		"status": 0
	},
	"map": {},
	"msg": ""
}
```


## logout


**url**:`/user/loginout`


**method**:`POST`


**produces**:`application/json`


**consumes**:`*/*`


**Note**:


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|creationTime||query|false|integer(int64)||
|id||query|false|string||
|lastAccessedTime||query|false|integer(int64)||
|maxInactiveInterval||query|false|integer(int32)||
|new||query|false|boolean||
|valueNames||query|false|array|string|


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## sendMsg


**url**:`/user/sendMsg`


**method**:`POST`


**produces**:`application/json`


**consumes**:`*/*`


**Note**:


**Example**:


```javascript
{
  "avatar": "",
  "id": 0,
  "idNumber": "",
  "name": "",
  "phone": "",
  "sex": "",
  "status": 0
}
```


**Params**:


| name | description | in    | require | type | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|user|user|body|true|User|User|
|&emsp;&emsp;avatar|||false|string||
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;idNumber|||false|string||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;sex|||false|string||
|&emsp;&emsp;status|||false|integer(int32)||
|creationTime||query|false|integer(int64)||
|id||query|false|string||
|lastAccessedTime||query|false|integer(int64)||
|maxInactiveInterval||query|false|integer(int32)||
|new||query|false|boolean||
|valueNames||query|false|array|string|


**Status**:


| code | description | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**Response Params**:


| name | description | type | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**Response Example**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```