<template>
    <div>
      <ul class="list-group list-group-flush">
        <li v-for="line in prayersList" :key="line.hour" class="list-group-item">
            {{ line.user }}
        </li>
    </ul>
    </div>
</template>

<script>
import { mapGetters } from 'vuex'


export default {
    data() {
        return {
            
        }
    },
    computed: {
        ...mapGetters({
           prayersList: 'prayersList'
        }),
    },
    
}
</script>