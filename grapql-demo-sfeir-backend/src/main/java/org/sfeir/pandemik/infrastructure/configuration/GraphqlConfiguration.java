package org.sfeir.pandemik.infrastructure.configuration;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

//@Configuration
public class GraphqlConfiguration {

    private GraphQL graphQL;
    private GraphQLDataFetcher dataFetcher;

    @PostConstruct
    public void init() throws IOException {
        // Scema file
        File schemaFile = ResourceUtils.getFile("classpath:countries.graphqls");
        this.graphQL = GraphQL.newGraphQL(buildSchema(schemaFile)).build();
    }

    private GraphQLSchema buildSchema(File schema) {
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schema);
        RuntimeWiring wiring = wiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, wiring);
    }

    private RuntimeWiring wiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query")
                        .dataFetcher("patientByName", dataFetcher.getPatientByName())
                        .dataFetcher("territoryByName", dataFetcher.getTerritoryByName())
                        .dataFetcher("virusByName", dataFetcher.getVirusByName()))
                .build();

    }


    @Bean
    public GraphQL graphQL() {
        return this.graphQL;
    }

    //@Autowired
    public void setDataFetcher(GraphQLDataFetcher dataFetcher) {
        this.dataFetcher = dataFetcher;
    }

}
