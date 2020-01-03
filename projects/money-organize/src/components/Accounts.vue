<template>
  <div class="products">
    <div class="card mt-5">
      <h5 class="card-header">Contas</h5>
      <div class="card-body">
        <div class="row">
          <div class="form-group col-sm-6">
            <input v-model="search" placeholder="Busca por banco" type="text" class="form-control" required>
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
                <th>Ações</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="account in accounts" v-bind:key="account.id">
                  <td>{{account.id}}</td>
                  <td>{{account.bank}}</td>
                  <td>
                    <a href="#" class="icon">
                      <i v-on:click="onDelete(account.id)" class="fa fa-trash"></i>
                    </a>
                    <a href="#" class="icon">
                      <i data-toggle="modal" data-target="#staticBackdrop" v-on:click="onEdit(account)" class="fa fa-pencil"></i>
                    </a>
                    <a href="#" class="icon">
                      <i data-toggle="modal" data-target="#staticBackdrop" v-on:click="onView(account)" class="fa fa-eye"></i>
                    </a>
                  </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="staticBackdropLabel">Conta</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form>
              <div class="form-group">
                <label >Código:</label>
                <input v-model="account.id" type="text" :readonly="readonly" class="form-control"  required>
              </div>
              <div class="form-group">
                <label>Banco:</label>
                <input v-model="account.bank" type="text" :readonly="readonly" class="form-control" required>
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
import accounts from '@/db/accounts.js'

export default {
  name: 'Accounts',
  data () {
    return {
      search: '',
      accounts: null,
      editId: '',
      account: {
        'id' : '',
        'bank': ''
      },
      readonly: false
    }
  },
  created() {
    this.getAccounts();
  },
  methods: {
    getAccounts() {
     this.accounts = accounts;
     return this.accounts;
    },
    onSubmit(){
      this.accounts.push(this.accounts);
      this.clean();
    },
    onDelete(id){
      db.collection('products').doc(id).delete().then((data)=> {
          this.getAccounts()
      })
    },
    onEdit(account){
      this.readonly = false;
      this.account = account;
    },
    onView(account){
      this.readonly = true;
      this.account = account;
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
      this.accounts.id = '';
      this.accounts.bank = '';
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
