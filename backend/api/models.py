from django.db import models

# Create your models here.

class Cardapio(models.Model):
  id_cardapio  = models.AutoField(primary_key=True)
  nome         = models.CharField(max_length=255)
  preco        = models.FloatField()
  ingredientes = models.TextField()
  
class Usuarios(models.Model):
  id_usuario = models.AutoField(primary_key=True)
  email      = models.EmailField()
  senha      = models.CharField(max_length=255) 