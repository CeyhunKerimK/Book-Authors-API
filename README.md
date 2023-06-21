![](obsolete-turntable-old-fashioned-table-nightclub-generated-by-ai.jpg)
# Proje için gerekli ortamın hazırlanması:
```ad-warning
title:Gereksinimler
projenin çalıştırılmak istenen bilgisayarda açılamabilmesi için bilgisayarınız üstünde java jdk 11 ve üstü,
mongodb veritabanı ve mongodbCompass bulunması gerekmektedir.
```


#### Projede bulunan Spring Boot bağımlılıkları:

```ad-hint
<ul>
<li>Spring Data MongoDB</li>
<li>Spring Data JPA</li>
<li>Spring Web</li>
<li>Spring Boot DevTools</li>
</ul>
```

# Yazarlar ile alakalı endpointler ve işlevleri;
## Yazar koleksiyonundan objerin çağırılması
Method : GET
```ad-hint
title:ENDPOİNT
https://localhost:8080/show-yazarlar
```
kullanım : Bu endpoint üstünden veritabanına bir GET isteği gönderilir ve yazarlar koleksiyonundaki tüm objeler tarayıcı veya bu isteğin yapıldığı uygulama üstünde çağırılır.
```ad-example
title:işlem sonucu döndürülen objeler
![[show-yazarlar.png]]
```

## Yazar koleksiyonuna yeni bir obje eklenmesi
Method : POST
endpoint : https://localhost:8080/add-yazar
Kullanım : Bu endpoint üstünden veritabanına yeni bir POST isteği gönderilir ve veritabanına bir json objesi kaydedilir.
```json
{
	"isim": "Ransom Riggs",
	"kitaplar": [
			 "gölge şehir",
			 "bayan peregrine weird childs",
			 "haritalar odasi"
			 ],
	"yas": 56
}
```
gönderilecek json objelerinde gösterilecek objelerin tüm özellikler ceyhunkerim.yazar.model içerisinde bulunan @Document java sınıfında belirlenir.
## Yazarlar koleksiyonundaki bir objeyi güncellemek
Method : PUT
```ad-hint
title:endpoint
 https://localhost:8080/update-yazar
```
Kullanım : bu endpoint üstünden veritabanına bir PUT isteği gönderilir ve veri tekrardan isteğin gövde kısmından gelen bir json verisi ile değiştirilir.
Örneğin;
```json
{
	'isim': 'Arthur Conan Doyle',
	'kitaplar':[
		'sherlock holmes kızıl dosya',
		'sherlock holmes dörtlerin yemini',
		'sherlock holmes Baskerville'nin köğeği
	],
	'yas':65
}
```
burada yazılmış olan obje içerisinde bir hata yapıldı ve öldüğünde yaşı 71 olan Arthur Conan Doyle'un yaşı 65 olarak girildi. Bunu bir web aplikasyonunda kullanan kullanıcı burada ki bilgiyi güncellemek istiyor.
Bunun için yapmasın gereken bir PUT isteği yapmak olacaktır.
```json
{

    "isim": "Ransom Riggs",
    "kitaplar": [
        "gölge şehir",
        "bayan peregrine weird childs",
        "haritalar odasi"
    ],
    "yas": 44
}
```
burada ki yazılan yeni objeyi bu endpoint'ten API'ye göndermesi yeterli olacaktır.
## Yazarlar koleksiyonundaki bir objeyi silmek
METHOD : DELETE
```ad-info
title:endpoint
http://localhost:8080/delete-yazar/{yazar}
```
Kullanımı : Bu endpoint üstünden ismi girilen yazar veritabanından silinir.


# Kitaplar hakkındaki endpointler ve işlevleri;
## Kitaplar koleksiyonundaki tüm objerleri görüntülemek
METHOD : GET
```url
https://localhost:8080/show-kitaplar
```
Kullanım : Bu istekle beraber koleksiyon içinde bulunan tüm objeleri tarayıcı veya postman gibi bir uygulama kullanılıyorsa oraya çağırır.

```ad-example
title:işlem sonucu tarayıda döndürülen objeler
![[show-kitaplar.png]]
```
## Kitaplar koleksiyonuna yeni bir obje eklemek
METHOD : POST
```ad-info
title:endpoint
https://localhost:8080/add-kitap
```
Kullanım : bu endpoint üstünden veritabanına yeni bir kitap verisi gönderilir. Gönderilecek veriler json veri tipinde şu şekilde olmalıdır;
```json
 {
    "kitapAdi": "The Last Olympian",
	"yayinlanmaYili": "2009",
	"sayfaSayisi": 381,
	"yazar": "Rick Riordan",
	"tur": "Fantasy"
}
```
## Kitaplar koleksiyonundaki bir objeyi güncellemek
MEHOD : PUT

```ad-info
title:endpoint
https://localhost:8080/update-kitap/{kitapAdi}
```
bu endpoint üstünden veritabanındaki yazılan kitap ismine sahip objeyi aratarak obje üstünde istediğimiz bir değişikliği gerçekleştiriyoruz.
## Kitaplar koleksiyonundan obje silme
METHOD : DELETE
```ad-info
title:endpoint
https://localhost:8080/delete-kitap/{kitapAdi}
```
Kullanım : Bu endpoint sayesinde ise veritabanındaki aynı kitap ismine sahip objeyi siliyoruz.
## Kitaplar koleksiyonundaki kitapları sorgulatma
METHOD : GET
```ad-info
title:endpoint
http://localhost:8080/show-kitaplar/{yazar}
```
Kullanım : Bu endpoint sayesinde ise ismi yazılan bir yazarın ismini kitaplar veritabanındaki her bir objede bulunan yazar değişkenin içini filtreliyerek kontrol ederek kullanıcıya geri sunuyoruz.

```ad-note
title:veritabanına bağlantı ve oluşturma işlemleri
 application.properties dosyasında veritabanına bağlanma yöntemini tanıtıyoruz aşağıda bunun uygulanmış bir örneği bulunmaktadır.
```
```ad-info
spring.data.mongodb.host=localhost  
spring.data.mongodb.port=27017  
spring.data.mongodb.database=yazarDatabase
```
burada localhost yani yerel makine üzerinde 27017.porta bağlanmasını ve burada yazarDatabase isimli bir veritabanına bulup bağlanmasını belirtiyoruz.
