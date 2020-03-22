<template>
    <div>
        <!-- Menu -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Home</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/watch">Lista <span class="sr-only">(current)</span></a>
                    </li>
                </ul>
            </div>
        </nav>
        
        <hr>

        <div class="container" style="margin-top: 20px">
            <div class="row">
                <div class="col-sm">
                    <b-form>
                        <b-form-group
                            id="user"
                            label="Nome Completo"
                            label-for="user">
                            <b-form-input v-model="user" id="user" required placeholder="Enter name"></b-form-input>

                            <button @click="registerPrayer" type="button" style="margin-top: 10px" class="btn btn-primary">Registrar</button>
                        </b-form-group>
                    </b-form>
                </div>
            </div>
        </div>

        <div class="mt-3">
            <b-card-group deck>
            <b-card header="Manhã" class="text-center">
                <table class="table table-reponsive-sm table-sm table-striped">
                <thead>
                    <tr>Horário</tr>
                </thead>
                    <tbody>
                    <tr v-for="line in activeHours" :key="line.hour">
                        <td>
                            <div class="custom-control custom-checkbox">
                                <input :disabled="line.used" v-model="selected" :value="line.hour" class="custom-control-input" :id="line.hour" type="checkbox" />
                                <label class="custom-control-label" :for="line.hour"> {{ line.hour }}</label>
                            </div> 
                        </td>
                    </tr>
                    </tbody>
                </table>
            </b-card>

            <b-card header="Tarde" class="text-center">
                
            </b-card>

            <b-card header="Noite" class="text-center">
               
            </b-card>
            </b-card-group>
      </div>
    </div>
  
</template>

<script>
import { mapGetters } from 'vuex'
import { mapActions } from 'vuex'

export default {
    data() {
        return {
            selected: [],
            user: null,
            availableHours: this.activeHours
        }
    },
    computed: {
        ...mapGetters({
            prayer: 'prayer',
            activeHours: 'activeHours'
        }),

        activeHours() {
            return this.$store.getters.activeHours
        }

        
    },
    methods: {
        ...mapActions(['register']),

        registerPrayer() {
            const schedule = {
                hour: this.selected,
                user: this.user
            }
        
            this.register(schedule)
            
        }
    },
    
}
</script>