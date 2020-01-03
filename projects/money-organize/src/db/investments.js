import goals from './goals'
import accounts from './accounts'

export default [
    {
        id: 1, 
        type: 'CDI',
        initialValue: 1000,
        endValue: '',
        applicationDate: new Date(2019, 3, 20),
        dueDate: new Date(2022, 3, 20),
        account: accounts[0],
        goal: goals[0],
        amount: 10,
        profitability: 1.2
    },
    {
        id: 2, 
        type: 'FII',
        initialValue: 1000,
        endValue: '',
        applicationDate: new Date(2019, 1, 20),
        dueDate: null,
        account: accounts[2],
        goal: goals[2],
        amount: 28,
        profitability: 0
    },
    {
        id: 3, 
        type: 'CDB',
        initialValue: 1000,
        endValue: '',
        applicationDate: new Date(2019, 1, 20),
        dueDate: new Date(2022, 1, 20),
        account: accounts[1],
        goal: goals[1],
        amount: 10,
        profitability: 1.2
    }
]