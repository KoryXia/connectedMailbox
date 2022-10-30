# Connected Mailbox API Documents


**Description**:Connected Mailbox API Documents

**HOST**:localhost:8080


[TOC]






# interphone-controller


## getAllInterphones

**url**:`/api/interphone/getAllInterphone`

**method**:`GET`

**produces**:`application/x-www-form-urlencoded`

**Params**:

None

**Response Example**:

```json
{
    "msg": "success",
    "res": {
        "records": [
            {
                "interphoneId": "3cb7aac0-5b49-4906-86d5-98e0780df84c",
                "city": "Paris",
                "address": "6 boulevard jourdan ",
                "postalCode": "75014",
                "country": "France"
            },
            {
                "interphoneId": "417ecd96-92eb-46a8-899d-60bc21a796d2",
                "city": "Issy les moulineaux",
                "address": "17 Rue du Général Leclerc",
                "postalCode": "92130",
                "country": "France"
            },
            {
                "interphoneId": "7b658eff-d8e5-407a-a984-0bf49e4f24f2",
                "city": "Issy les moulineaux",
                "address": "10 rue de vanve",
                "postalCode": "92130",
                "country": "France"
            },
            {
                "interphoneId": "89869ef3-3a9d-49aa-b3a1-be6d61e72c49",
                "city": "Paris",
                "address": "28 Rue Notre Dame des Champs",
                "postalCode": "75006",
                "country": "France"
            },
            {
                "interphoneId": "97836776-feb6-481f-b178-185173a88394",
                "city": "Issy les moulineaux",
                "address": "4 Pl. Paul Vaillant Couturier",
                "postalCode": "92130",
                "country": "France"
            },
            {
                "interphoneId": "bd54ba9f-2b16-43f5-afe5-741ae46f5763",
                "city": "Paris",
                "address": "16 Rue du Montparnasse",
                "postalCode": "75006",
                "country": "France"
            }
        ],
        "total": 0,
        "size": 10,
        "current": 1,
        "orders": [],
        "optimizeCountSql": true,
        "searchCount": true,
        "countId": null,
        "maxLimit": null,
        "pages": 0
    }
}
```


## getInterphoneById


**url**:`/api/interphone/{id}`

**method**:`GET`

**produces**:`application/x-www-form-urlencoded`

**Params**:


| name | description | in   | require | type   | schema |
| ---- | ----------- | ---- | ------- | ------ | ------ |
| id   | id          | path | true    | string |        |


**Response Example**:

```json
{
    "msg": "success",
    "res": {
        "interphoneId": "3cb7aac0-5b49-4906-86d5-98e0780df84c",
        "city": "Paris",
        "address": "6 boulevard jourdan ",
        "postalCode": "75014",
        "country": "France"
    }
}
```


# letter-controller


## getAllLettersByMailboxId


**url**:`/api/letter/{id}`

**method**:`GET`

**produces**:`application/x-www-form-urlencoded`


**Params**:


| name | description | in   | require | type   | schema |
| ---- | ----------- | ---- | ------- | ------ | ------ |
| id   | id          | path | true    | string |        |


**Response Example**:

```json
{
    "msg": "success",
    "res": [
        {
            "letterId": 1,
            "mailboxId": "e704ee83-874d-476e-8fc7-39b6038eca5f",
            "gotNew": false,
            "dateTime": "2022-10-29 10:58:35"
        }
    ]
}
```


# mailbox-controller


## bindMailbox

**url**:`/api/mailbox/bind`

**method**:`POST`

**produces**:`application/json`


**Params**:


| name           | description | in    | require | type    | schema |
| -------------- | ----------- | ----- | ------- | ------- | ------ |
| interphoneId   |             | query | false   | string  |        |
| isHasNewLetter |             | query | false   | boolean |        |
| mailboxId      |             | query | false   | string  |        |
| nickname       |             | query | false   | string  |        |
| screenInfo     |             | query | false   | string  |        |
| userId         |             | query | false   | string  |        |


**Response Example**:

```json
{
    "msg": "failed",
    "res": {
            "mailboxId": "82716858-585e-11ed-9b6a-0242ac120002",
            "interphoneId": "89869ef3-3a9d-49aa-b3a1-be6d61e72c49",
            "nickname": "maison2",
            "userId": "28cac31a-6b43-4f8b-b492-bdc0faf94b4c",
            "gotNew": false,
            "screenInfo": "Julian Mac"
    },
}
```


## getAllMailboxsByUserId


**url**:`/api/mailbox/{id}`


**method**:`GET`

**produces**:`application/x-www-form-urlencoded`

**Params**:


| name | description | in   | require | type   | schema |
| ---- | ----------- | ---- | ------- | ------ | ------ |
| id   | id          | path | true    | string |        |


**Response Example**:

```javascript
{
    "msg": "success",
    "res": [
        {
            "mailboxId": "82716858-585e-11ed-9b6a-0242ac120002",
            "interphoneId": "89869ef3-3a9d-49aa-b3a1-be6d61e72c49",
            "nickname": "maison2",
            "userId": "28cac31a-6b43-4f8b-b492-bdc0faf94b4c",
            "gotNew": false,
            "screenInfo": "Julian Mac"
        },
        {
            "mailboxId": "aa65c09f-a6fc-4eb7-b8c1-ac741246b124",
            "interphoneId": "417ecd96-92eb-46a8-899d-60bc21a796d2",
            "nickname": "maison1",
            "userId": "28cac31a-6b43-4f8b-b492-bdc0faf94b4c",
            "gotNew": false,
            "screenInfo": "Julian Mac"
        }
    ]
}
```


# user-controller


## getUserToken


**url**:`/api/user/getUserToken`


**method**:`GET`

**produces**:`application/x-www-form-urlencoded`


**Params**:


| name | description | in    | require | type   | schema |
| ---- | ----------- | ----- | ------- | ------ | ------ |
| id   | id          | query | true    | string |        |


**Response Example**:

```javascript
{
    "msg": "success",
    "res": {
        "userId": "9ff42bae-b225-4e3d-8ee0-85009250d383",
        "token": ""
    }
}
```


## userLoginIn

**url**:`/api/user/login`


**method**:`POST`

**produces**:`application/json`


**Params**:


| name     | description | in    | require | type   | schema |
| -------- | ----------- | ----- | ------- | ------ | ------ |
| phone    | phone       | query | true    | string |        |
| password | password    | query | true    | string |        |

**Response Example**:

```javascript
{
    "msg": "success",
    "res": {
        "userId": "28cac31a-6b43-4f8b-b492-bdc0faf94b4c",
        "name": "Julian Mac",
        "address": "6 boulevard jourdan ",
        "room": "2A",
        "phone": "0612345678",
        "city": "Paris",
        "country": "France",
        "postalCode": "75014"
    }
}
```


## updateToken


**url**:`/api/user/updateToken`

**method**:`POST`


**produces**:`application/json`

**Params**:


| name   | description | in    | require | type   | schema |
| ------ | ----------- | ----- | ------- | ------ | ------ |
| userId | userId      | query | true    | string |        |
| token  | token       | query | true    | string |        |

**Response Example**:

```javascript
{
    "msg": "success"
}
```


## getUserInfo


**url**:`/api/user/{id}`


**method**:`GET`

**produces**:`application/x-www-form-urlencoded`


**Params**:


| name | description | in   | require | type   | schema |
| ---- | ----------- | ---- | ------- | ------ | ------ |
| id   | id          | path | true    | string |        |


**Response Example**:

```javascript
{
    "msg": "success",
        "res": {
        "userId": "28cac31a-6b43-4f8b-b492-bdc0faf94b4c",
            "name": "Julian Mac",
            "address": "6 boulevard jourdan ",
            "room": "2A",
            "phone": "0612345678",
            "city": "Paris",
            "country": "France",
            "postalCode": "75014"
    }
}
```