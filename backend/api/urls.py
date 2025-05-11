from django.urls import path, include
from api import viewsets
from rest_framework import routers

# Routers provide an easy way of automatically determining the URL conf.
router = routers.DefaultRouter()
router.register("cardapio", viewsets.CardapioViewSet)
router.register("usuarios", viewsets.UsuariosViewSet)


urlpatterns = [
  path('api/', include(router.urls)),
]
