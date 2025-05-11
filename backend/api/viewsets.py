from rest_framework import viewsets
from api import serializers
from api import models

class CardapioViewSet(viewsets.ModelViewSet):
  serializer_class = serializers.CardapioSerializer
  queryset = models.Cardapio.objects.all()

class UsuariosViewSet(viewsets.ModelViewSet):
  serializer_class = serializers.UsuariosSerializer
  queryset = models.Usuarios.objects.all()