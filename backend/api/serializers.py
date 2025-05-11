from rest_framework import serializers
from api import models

class CardapioSerializer(serializers.ModelSerializer):
  class Meta:
    model = models.Cardapio
    fields = '__all__'

class UsuariosSerializer(serializers.ModelSerializer):
  class Meta:
    model = models.Usuarios
    fields = '__all__'