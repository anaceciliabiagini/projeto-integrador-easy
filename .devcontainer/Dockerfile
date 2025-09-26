FROM mcr.microsoft.com/devcontainers/java:21

# Instala Maven diretamente via apt-get
RUN apt-get update \
    && apt-get install -y maven  git-lfs \
    && rm -rf /var/lib/apt/lists/*  # Limpa o cache do apt para reduzir o tamanho da imagem