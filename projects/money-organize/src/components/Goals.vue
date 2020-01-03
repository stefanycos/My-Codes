<template>
  <div class="products">
    <!-- Modal -->
    <div class="modal fade" id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="staticBackdropLabel">Meta</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form v-on:submit.prevent="onSubmit">
              <div class="form-group">
                <label >Código:</label>
                <input v-model="goal.id" type="text" :readonly="readonly" class="form-control"  required>
              </div>
              <div class="form-group">
                <label>Nome:</label>
                <input v-model="goal.name" type="text" :readonly="readonly" class="form-control" required>
              </div>
              <div class="form-group">
                <label>Valor:</label>
                <input v-model="goal.goal_value" type="text" :readonly="readonly" class="form-control" required>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
            <button v-show="!readonly" type="button" @click="onSubmit()" class="btn btn-primary">Salvar</button>
          </div>
        </div>
      </div>
    </div>

    <div class="card mt-5">
      <h5 class="card-header">Metas</h5>
      <div class="card-body">
        <div class="row">
          <div class="form-group col-sm-6">
            <input v-model="search" placeholder="Busca por nome" type="text" class="form-control" required>
          </div>
          <div class="ml-auto text-right col-sm-6">
            <button type="button" @click="onCreate()" class="btn btn-primary" data-toggle="modal" data-target="#staticBackdrop">
                Novo
            </button>
          </div>
        </div>
        <div class="table-responsive">
          <table class="table">
            <thead>
              <tr>
                <th scope="col">
                  Código
                </th>
                <th>
                  Nome
                </th>
                <th>
                  Valor atual
                </th>
                <th>
                  Ações
                </th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="goal in goals" v-bind:key="goal.id">
                <td>
                  {{goal.id}}
                  </td>
                  <td>
                    {{goal.name}}
                  </td>
                  <td>
                    {{goal.current_value}}
                  </td>
                  <td>
                    <a href="#" class="icon">
                      <i v-on:click="onDelete(goal.id)" class="fa fa-trash"></i>
                    </a>
                    <a href="#" class="icon">
                      <i data-toggle="modal" data-target="#staticBackdrop" v-on:click="onEdit(goal)" class="fa fa-pencil"></i>
                    </a>
                    <a href="#" class="icon">
                      <i data-toggle="modal" data-target="#staticBackdrop" v-on:click="onView(goal)" class="fa fa-eye"></i>
                    </a>
                  </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import db from '@/db'
import goals from '@/db/goals.js'

export default {
  name: 'Goals',
  data () {
    return {
      search: '',
      goals: null,
      editId: '',
      goal: {
        'id' : '',
        'name': '',
        'current_value': '',
        'goal_value': ''
      },
      readonly: false
    }
  },
  created() {
    this.getProducts();
  },
  methods: {
    getProducts() {
     this.goals = goals;
     return this.goals;
    },
    onSubmit(){
      this.goals.push(this.goal);
      this.clean();
    },
    onDelete(id){
      db.collection('products').doc(id).delete().then((data)=> {
          this.getProducts()
      })
    },
    onEdit(goal){
      this.readonly = false;
      this.goal = goal;
    },
    onView(goal){
      this.readonly = true;
      this.goal = goal;
    },
    onCreate(){
      this.readonly = false;
      this.clean();
    },
    onEditSubmit (id){
      db.collection("products").doc(id).set(this.editProductData).then(
        this.getProducts)
        this.editId = ''
        this.editProductData.product_id = ''
        this.editProductData.product_name = ''
        this.editProductData.product_price = ''
    },
    clean(){
      this.goal.id = '';
      this.goal.current_value = '';
      this.goal.name = '';
      this.goal.goal_value = '';
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
table{
  margin-top: 30px
}
.icon{
  margin-right: 10px;
}
.icon i{
  cursor: pointer;
}
</style>
