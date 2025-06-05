FROM pgvector/pgvector:pg17

# Add PostgreSQL APT repo and install system/extension dependencies
RUN apt-get update && apt-get install -y \
    wget \
    gnupg \
    lsb-release \
    ca-certificates \
    git \
    build-essential \
    postgresql-server-dev-17 \
    postgresql-17-http && \
    echo "deb http://apt.postgresql.org/pub/repos/apt $(lsb_release -cs)-pgdg main" > /etc/apt/sources.list.d/pgdg.list && \
    wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | apt-key add - && \
    apt-get update && \
    rm -rf /var/lib/apt/lists/*

# Clone and install pgsql-openai using its Makefile (PGXS)
RUN git clone https://github.com/pramsey/pgsql-openai.git /tmp/pgsql-openai && \
    cd /tmp/pgsql-openai && \
    make && make install && \
    rm -rf /tmp/pgsql-openai
