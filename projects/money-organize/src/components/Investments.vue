<template>
  <div class="products">
    <div class="card mt-5">
      <h5 class="card-header">Investimentos</h5>
      <div class="card-body">
        <div class="row">
          <div class="form-group col-sm-6">
            <input v-model="search" placeholder="Busca por tipo" type="text" class="form-control" required>
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
                <th scope="col">Código</th>
                <th>Banco</th>
                <th>Tipo</th>
                <th>Meta</th>
                <th>Vencimento</th>
                <th>Ações</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="investment in investments" v-bind:key="investment.id">
                  <td>{{ investment.id }}</td>
                  <td>{{ investment.account.bank }}</td>
                  <td>{{ investment.type }}</td>
                  <td>{{ investment.goal.name }}</td>
                  <td>{{ formateDate(investment.dueDate) }}</td>
                  <td>
                    <a href="#" class="icon">
                      <i v-on:click="onDelete(investment.id)" class="fa fa-trash"></i>
                    </a>
                    <a href="#" class="icon">
                      <i data-toggle="modal" data-target="#staticBackdrop" v-on:click="onEdit(investment)" class="fa fa-pencil"></i>
                    </a>
                    <a href="#" class="icon">
                      <i data-toggle="modal" data-target="#staticBackdrop" v-on:click="onView(investment)" class="fa fa-eye"></i>
                    </a>
                  </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>

    <!-- Modal -->
    <div class="modal fade bd-example-modal-lg" id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
      <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="staticBackdropLabel">Conta</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form>
              <div class="container">

                <div class="row">
                  <div class="form-group col-sm">
                    <label >Código:</label>
                    <input v-model="investment.id" type="text" :readonly="readonly" class="form-control"  required>
                  </div>
                  <div class="form-group col-sm">
                    <label>Banco:</label>
                    <input v-model="investment.bank" type="text" :readonly="readonly" class="form-control" required>
                  </div>
                  <div class="form-group col-sm">
                    <label>Tipo:</label>
                    <select class="custom-select">
                      <option value="CDI">CDI</option>
                      <option value="CDB">CDB</option>
                      <option value="FII">FII</option>
                    </select>
                  </div>
                </div>

                <div class="row">
                  <div class="form-group col-sm">
                    <label >Valor:</label>
                    <input v-model="investment.initialValue" type="text" :readonly="readonly" class="form-control"  required>
                  </div>
                  <div class="form-group col-sm">
                    <label >Quantidade:</label>
                    <input v-model="investment.amount" type="text" :readonly="readonly" class="form-control" >
                  </div>
                  <div class="form-group col-sm">
                    <label >Rendimento:</label>
                    <input v-model="investment.profitability" type="text" :readonly="readonly" class="form-control" >
                  </div>
                </div>
                
                <div class="row">
                  <div class="form-group col-sm">
                    <label >Meta:</label>
                    <select class="custom-select">
                      <option v-for="goal in goals" :key="goal.id" :value="goal.id">{{ goal.name }}</option>
                    </select>
                  </div>
                  <div class="form-group col-sm">
                    <label >Conta:</label>
                    <select class="custom-select">
                      <option v-for="account in accounts" :key="account.id" :value="account.id">{{ account.bank }}</option>
                    </select>
                  </div>
                </div>
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
  </div>
</template>

<script>
import db from '@/db'
import investments from '@/db/investments.js'
import goals from '@/db/goals.js'
import accounts from '@/db/accounts.js'

export default {
  name: 'Investments',
  data () {
    return {
      goals: goals,
      accounts: accounts,
      search: '',
      investments: null,
      editId: '',
      investment: {
        id: '', 
        type: '',
        initialValue: null,
        endValue: '',
        applicationDate: null,
        dueDate: null,
        account: null,
        goal: null,
        amount: null,
        profitability: null
      },
      readonly: false,
      types: {

      }
    }
  },
  created() {
    this.getAccounts();
  },
  methods: {
    getAccounts() {
     this.investments = investments;
     return this.investments;
    },
    onSubmit(){
      this.investments.push(this.investment);
      this.clean();
    },
    onDelete(id){
      db.collection('products').doc(id).delete().then((data)=> {
          this.getAccounts()
      })
    },
    onEdit(investment){
      this.readonly = false;
      this.investment = investment;
    },
    onView(investment){
      this.readonly = true;
      this.investment = investment;
    },
    onCreate(){
      this.readonly = false;
      this.clean();
    },
    onEditSubmit (id){
      db.collection("products").doc(id).set(this.editProductData).then(
        this.getAccounts)
        this.editId = ''
        this.editProductData.product_id = ''
        this.editProductData.product_name = ''
        this.editProductData.product_price = ''
    },
    clean(){
      
    },
    formateDate(date){
      if(date){
        var day = date.getDate().toString();
        var formattedDay = (day.length == 1) ? '0' + day : day;
        var month  = (date.getMonth()+1).toString();
        var formatedMonth = (month.length == 1) ? '0' + month : month;
        var year = date.getFullYear();
  
        return formattedDay + "/" + formatedMonth + "/" + year;
      }

      return "N/A"
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
