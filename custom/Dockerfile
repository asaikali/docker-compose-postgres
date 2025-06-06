# Use pgvector base image for PostgreSQL 17
FROM pgvector/pgvector:pg17

# Add PostgreSQL APT repo and install build dependencies
RUN apt-get update && apt-get install -y \
    wget \
    gnupg \
    lsb-release \
    ca-certificates \
    git \
    build-essential \
    libcurl4-openssl-dev \
    postgresql-server-dev-17 \
 && echo "deb http://apt.postgresql.org/pub/repos/apt $(lsb_release -cs)-pgdg main" > /etc/apt/sources.list.d/pgdg.list \
 && wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | apt-key add - \
 && apt-get update \
 && rm -rf /var/lib/apt/lists/*

# Clone and build pgsql-http from source
RUN git clone https://github.com/pramsey/pgsql-http.git /tmp/pgsql-http \
 && cd /tmp/pgsql-http \
 && make \
 && make install \
 && rm -rf /tmp/pgsql-http

# Clone and build pgsql-openai from source
RUN git clone https://github.com/pramsey/pgsql-openai.git /tmp/pgsql-openai \
 && cd /tmp/pgsql-openai \
 && make \
 && make install \
 && rm -rf /tmp/pgsql-openai
