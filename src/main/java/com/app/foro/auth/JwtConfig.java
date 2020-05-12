package com.app.foro.auth;

public class JwtConfig {
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEowIBAAKCAQEAtT4jWuycJsJuKG5i8GdvSicfw0fzFkx4yr96Zl2PsX359hrY\r\n" + 
			"etU9ueP+tc5xVXjASaj/tFnvd14zMcdJ79OhdFncYVIo092oG7XOaSesN9zI07DT\r\n" + 
			"GvAHwMpKobQHNoSevNEn/4HIuLsklFIBZKHkTXG+g82TLeqzXuAEeMj1aCgYZM1g\r\n" + 
			"NU90eMAU4C0ho3ePeV8WZ4x1XUZVyHOvPqRr8VFUGYzZokCnJAvQ5L2qITtp+vzH\r\n" + 
			"WU0VbRICMR9YrSWMDBa8daQA+ZRrcgYP1ahHzCXieQ7zY8byFBJbCqkcgisLkAb8\r\n" + 
			"FPF58z0C13c4P8hCQcIohmzEq+d4/kFSFpjntwIDAQABAoIBAAjmPjIuwBQfI+2U\r\n" + 
			"TgNj8NEBTsv18ne71YqPEGGKYo3ik62D7/FIGznPeihPNL1vqnFzfOrMJ7gCxhzB\r\n" + 
			"nl3KVHk0GGAm+p48mg6SRMphClHL44iRfCwscRUEWdnKzzfcFzdKRd6D7ukzNz6Z\r\n" + 
			"MDxSvrUWyrYKGBn/FkOoWE/d/j7Y8/0bz7n+E4WD+GTvQCZ1zo5hmzNM4/G+H4Dl\r\n" + 
			"9sQLgHId7YIzqIRl7soKfxZgYIdLvEpuciv3nvrfmvQYnAJcVoPz32UXY9Ho2kfz\r\n" + 
			"4T3/mb2YWaD6e2RKxv3D+IWaco/I2+nEbbu3IvxRdT8K6cy+/lJqWCFQS5qUN0cr\r\n" + 
			"bj9CldECgYEA4RPGnhOGc5BZvNLHbMwLvPfCvBBxiPUIZsQpf3Ds0tcVLMQd51G5\r\n" + 
			"yd9gg0Jb/nugim4EcalDzTnGY/G7GoXcCi08O+tCjI4+j7sM2KBq0CAlWxTfIl+m\r\n" + 
			"8icsl4QD5S7NEttDv1TYx58kRSj/4tgWPCqUJ0PcyiL8ME7hLnapUMsCgYEAziSm\r\n" + 
			"6SDYom6Q1Qlyqq6I249wod2KrN+5dYnSP43lECS0yPlgup+Q89z9T8rWOPVLq/zD\r\n" + 
			"JUluFEr0mfm9A9gGdFLPaqqd15jx7NWCROaTPu90lAOZ6Pq5bxi75XL/kxxc4b7C\r\n" + 
			"UolLje/TPyc21D0muNABuvZ58vzDCq7Xg6tTQ0UCgYEA2TElI1tCDfhIsA5RxKnt\r\n" + 
			"1c7bynCvrnKNReWbCdBlp1tHoqgpFxPlDWmRj3gUn7CajZp2jVvCAqLyz3TvkTuE\r\n" + 
			"xwk5q7Rsxodo1XexgMTj7axnf8nXPCtDRT8KJ7eLrreHyt9tM49jlNX7wQU8T6En\r\n" + 
			"a63Gw1EYGLLD2rXzU8vLvRsCgYANeNG7rJzbyLQIaCypQOzKxI4M1gipEZnyN4aZ\r\n" + 
			"BrHwoyV5eOq8Z482kLuxSkVDxawjWkp6lljuVJO1uF+E78pEMeFCTFIyc9ljq/Ru\r\n" + 
			"gk8fLtEEl1OoqTITM5+b+C8BsznSuv/CGxzn8sNwfiSULEbqjxV93XvMyH4KpbCJ\r\n" + 
			"91lirQKBgC2M11t+MgQZNPXnXhGj1OU+Ak7ptnnirsfUkwvbqU84jn2u6jri48Zq\r\n" + 
			"+KPWEpd6A23wZqISb1A3C4a8sM7XsJo2IdI/e9Tpc4nzLgHgIqqm7TtRpn4iVIXw\r\n" + 
			"/KY2h0IBHUyKwqGJOLTTdJYFF6M/pzFbqUxxyuKrvUE0PASBz9bs\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtT4jWuycJsJuKG5i8Gdv\r\n" + 
			"Sicfw0fzFkx4yr96Zl2PsX359hrYetU9ueP+tc5xVXjASaj/tFnvd14zMcdJ79Oh\r\n" + 
			"dFncYVIo092oG7XOaSesN9zI07DTGvAHwMpKobQHNoSevNEn/4HIuLsklFIBZKHk\r\n" + 
			"TXG+g82TLeqzXuAEeMj1aCgYZM1gNU90eMAU4C0ho3ePeV8WZ4x1XUZVyHOvPqRr\r\n" + 
			"8VFUGYzZokCnJAvQ5L2qITtp+vzHWU0VbRICMR9YrSWMDBa8daQA+ZRrcgYP1ahH\r\n" + 
			"zCXieQ7zY8byFBJbCqkcgisLkAb8FPF58z0C13c4P8hCQcIohmzEq+d4/kFSFpjn\r\n" + 
			"twIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";

}
